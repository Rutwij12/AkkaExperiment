package org.example;

import akka.actor.typed.ActorSystem;
import org.example.HelloWorldMain;

public class Main {

  public static void main(String[] args) {
    System.out.println("Hello world!");
    // Initialize the ActorSystem with HelloWorldMain behavior
    final ActorSystem<HelloWorldMain.SayHello> system = ActorSystem.create(HelloWorldMain.create(), "MySystem");

    // Send messages to the HelloWorldMain actor
    system.tell(new HelloWorldMain.SayHello("World"));
    system.tell(new HelloWorldMain.SayHello("Akka"));
  }
}
