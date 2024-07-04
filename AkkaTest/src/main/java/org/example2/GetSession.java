package org.example2;

import akka.actor.typed.ActorRef;

public final class GetSession implements RoomCommand {
  public final String screenName;
  public final ActorRef<SessionEvent> replyTo;

  public GetSession(String screenName, ActorRef<SessionEvent> replyTo) {
    this.screenName = screenName;
    this.replyTo = replyTo;
  }
}

