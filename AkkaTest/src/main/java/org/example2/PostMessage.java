package org.example2;

public final class PostMessage implements SessionCommand {

  public final String message;

  public PostMessage(String message) {
    this.message = message;
  }
}
