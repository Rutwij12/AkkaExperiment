package org.example;

import akka.actor.typed.ActorRef;
import akka.actor.typed.Behavior;
import akka.actor.typed.javadsl.AbstractBehavior;
import akka.actor.typed.javadsl.ActorContext;
import akka.actor.typed.javadsl.Behaviors;
import akka.actor.typed.javadsl.Receive;

public class HelloWorld extends AbstractBehavior<HelloWorld.Greet> {

  // defines 2 message types
  // 1. command the actor to greet someone
  // 2. to confirm that it has greeted successfully

  // Greet type contains info of whom to greet and actorRef that the sender of the message supplies for confirmation

  public static record Greet(String whom, ActorRef<Greeted> replyTo) {}
  public static record Greeted(String whom, ActorRef<Greet> from) {}

  // Factory method to create a Behaviour for actor
  // .setup initialises actor with specific context and creates instance of HelloWorld

  public static Behavior<Greet> create() {
    return Behaviors.setup(HelloWorld::new);
  }

  // Constructor
  private HelloWorld(ActorContext<Greet> context) {
    super(context);
  }

  // When a greet message is received, the onGreet method should be called
  @Override
  public Receive<Greet> createReceive() {
    return newReceiveBuilder().onMessage(Greet.class, this::onGreet).build();
  }

  // When onGreet is called it logs a message and then replies back to sender
  private Behavior<Greet> onGreet(Greet command) {
    getContext().getLog().info("Hello {}!", command.whom);
    command.replyTo.tell(new Greeted(command.whom, getContext().getSelf()));
    return this;
  }
}