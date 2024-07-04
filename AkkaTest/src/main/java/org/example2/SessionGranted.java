package org.example2;

import akka.actor.typed.ActorRef;

public final class SessionGranted implements SessionEvent {

  public final ActorRef<PostMessage> handle;

  public SessionGranted(ActorRef<PostMessage> handle) {
    this.handle = handle;
  }
}
