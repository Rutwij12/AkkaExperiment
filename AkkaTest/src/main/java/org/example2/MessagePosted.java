package org.example2;

public final class MessagePosted implements SessionEvent {

  public final String screenName;
  public final String message;

  public MessagePosted(String screenName, String message) {
    this.screenName = screenName;
    this.message = message;
  }
}
