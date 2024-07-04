package org.example2;

import akka.actor.typed.Behavior;
import akka.actor.typed.javadsl.AbstractBehavior;
import akka.actor.typed.javadsl.ActorContext;
import akka.actor.typed.javadsl.Behaviors;
import akka.actor.typed.javadsl.Receive;

public class MyLoggingBehavior extends AbstractBehavior<String> {

  public static Behavior<String> create() {
    return Behaviors.setup(MyLoggingBehavior::new);
  }

  private MyLoggingBehavior(ActorContext<String> context) {
    super(context);
  }

  @Override
  public Receive<String> createReceive() {
    return newReceiveBuilder().onMessage(String.class, this::onReceive).build();
  }

  private Behavior<String> onReceive(String message) {
    getContext().getLog().info("Received message: {}", message);
    return this;
  }
}
