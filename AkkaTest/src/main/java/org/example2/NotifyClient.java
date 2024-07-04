package org.example2;

public final class NotifyClient implements SessionCommand {

  public final MessagePosted message;

  NotifyClient(MessagePosted message) {
    this.message = message;
  }
}
