package org.example2;

import akka.actor.typed.Behavior;
import akka.actor.typed.javadsl.AbstractBehavior;
import akka.actor.typed.javadsl.ActorContext;
import akka.actor.typed.javadsl.Behaviors;
import akka.actor.typed.javadsl.Receive;

public class BackendManager extends AbstractBehavior<String> {

  public static Behavior<String> create() {
    return Behaviors.setup(
        context -> {
          context.setLoggerName(BackendManager.class);
          context.getLog().info("Starting up");
          return new BackendManager(context);
        });
  }

  private BackendManager(ActorContext<String> context) {
    super(context);
  }

  @Override
  public Receive<String> createReceive() {
    return newReceiveBuilder().onMessage(String.class, this::onReceive).build();
  }

  private Behavior<String> onReceive(String message) {
    getContext().getLog().debug("Received message: {}", message);
    return this;
  }
}
