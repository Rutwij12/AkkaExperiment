package org.example2;

import java.util.concurrent.CompletableFuture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class BackendTask {
  private final Logger log = LoggerFactory.getLogger(getClass());

  void run() {
    CompletableFuture<String> task =
        CompletableFuture.supplyAsync(
            () -> {
              // some work
              return "result";
            });
    task.whenComplete(
        (result, exc) -> {
          if (exc == null) log.error("Task failed", exc);
          else log.info("Task completed: {}", result);
        });
  }
}
