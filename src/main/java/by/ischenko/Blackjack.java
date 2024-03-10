package by.ischenko;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.IntStream;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Blackjack {

  @SneakyThrows
  public void playGame() {
    Queue<Card> queue = prepareDeck();
    int playerTotal = drawCard(queue) + drawCard(queue);
    int dealerTotal = drawCard(queue) + drawCard(queue);

    boolean playerBlackjack = (playerTotal == 21);
    boolean dealerBlackjack = (dealerTotal == 21);
    if (playerBlackjack && dealerBlackjack) {
      log.info("Both have a blackjack. Push.");
      return;
    }
    if (playerBlackjack) {
      log.info("Player has a blackjack. Player wins.");
      return;
    }
    if (dealerBlackjack) {
      log.info("Dealer has a blackjack. Dealer wins.");
      return;
    }

    boolean playerBusted = playTurn(queue, playerTotal, "Player");
    boolean dealerBusted = !playerBusted && playTurn(queue, dealerTotal, "Dealer");

    printResult(playerBusted, dealerBusted, playerTotal, dealerTotal);
  }

  private Queue<Card> prepareDeck() throws InterruptedException {
    List<Card> deck = new ArrayList<>();
    IntStream.range(0, 52).mapToObj(j -> new Card(j % 13, getCardValue(j))).forEach(deck::add);
    Collections.shuffle(deck);
    return new LinkedList<>(deck);
  }

  private int drawCard(Queue<Card> queue) throws InterruptedException {
    return queue.poll().value();
  }

  private boolean playTurn(Queue<Card> queue, int total, String playerType)
      throws InterruptedException {
    boolean busted = false;
    boolean done = false;
    while (!done) {
      if (total <= 16) {
        total += drawCard(queue);
        log.info(playerType + " hits. " + playerType + " total: " + total);
        if (total > 21) {
          busted = true;
          done = true;
          log.info(playerType + " busted.");
        }
      } else {
        done = true;
        log.info(playerType + " stands. " + playerType + " total: " + total);
      }
    }
    return busted;
  }

  @SuppressWarnings("java:S3358")
  private void printResult(boolean playerBusted, boolean dealerBusted, int playerTotal,
      int dealerTotal) {

    String result = """
        %s
        Player total: %d
        Dealer total: %d
        """.formatted(
        playerBusted ? "Player busted. Dealer wins." :
            dealerBusted ? "Dealer busted. Player wins." :
                playerTotal > dealerTotal ? "Player has a higher total. Player wins." :
                    playerTotal < dealerTotal ? "Dealer has a higher total. Dealer wins." :
                        "Both have the same total. Push.",
        playerTotal, dealerTotal
    );
    log.info(result);
  }

  private int getCardValue(int card) {
    int rank = card % 13;
    int value = rank + 1;
    if (value > 10) {
      value = 10;
    }
    if (value == 1) {
      value = 11;
    }
    return value;
  }

  private record Card(int rank, int value) {

  }
}
