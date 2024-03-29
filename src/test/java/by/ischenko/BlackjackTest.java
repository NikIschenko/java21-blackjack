package by.ischenko;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;

class BlackjackTest {

  public static int AMOUNT_OF_THREADS = 10_000;


  @Test
  void threadsArrayTest() {
    final Thread[] threads = new Thread[AMOUNT_OF_THREADS];
    for (int i = 0; i < AMOUNT_OF_THREADS; i++) {
      threads[i] = new Thread(() -> {
        new Blackjack().playGame();
      });
      threads[i].start();
    }
  }

  @Test
  void fixedThreadPoolTest() {
    try (var executor = Executors.newFixedThreadPool(6)) {
      IntStream.range(0, AMOUNT_OF_THREADS)
          .forEach(i -> executor.submit(() -> {
            new Blackjack().playGame();
          }));
    }
  }

  @Test
  void virtualThreadPerTaskTest() {
    try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
      IntStream.range(0, AMOUNT_OF_THREADS)
          .forEach(i -> executor.submit(() -> {
            new Blackjack().playGame();
          }));
    }
  }

  //-------------------------------------------------

  @Test
  void executorServiceTest() {
    ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();
    executor.submit(() -> {
      new Blackjack().playGame();
    });
  }

  @Test
  void startVirtualThreadTest() {
    Thread.startVirtualThread(() -> {
      new Blackjack().playGame();
    });
  }

  @Test
  void threadOfVirtualTest() {
    Thread.ofVirtual()
        .name("BlackjackGame")
        .start(() -> new Blackjack().playGame());
  }
}
