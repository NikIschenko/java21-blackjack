package by.ischenko;

import static by.ischenko.Blackjack.*;
import org.junit.jupiter.api.Test;

class RecordPatternsTest {


  @Test
  void recordPatternsJava17Test() {
    Card card1 = new PlayingCard("Jack","Hearts");
    Card card2 = new PlayingCard("9", "Spades");

    Object playerHand = new PlayerHand(card1, card2);
    if (playerHand instanceof PlayerHand ph) {
      if (ph.firstCard() instanceof PlayingCard c1 && ph.secondCard() instanceof PlayingCard c2) {
        System.out.println("First card: " + c1);
        System.out.println("Second card: " + c2);
        if (getValue(c1) + getValue(c2) == 21) {
          System.out.println("Blackjack!");
        } else {
          System.out.println("Total hand value: " + (getValue(c1) + getValue(c2)));
        }
      }
    }
  }

  @Test
  void recordPatternsJava21Test() {
    Card card1 = new PlayingCard("Jack", "Hearts");
    Card card2 = new PlayingCard("Ace", "Spades");

    Object playerHand = new PlayerHand(card1, card2);
    if (playerHand instanceof PlayerHand(PlayingCard c1, PlayingCard c2)) {
      System.out.println("First card: " + c1);
      System.out.println("Second card: " + c2);
      if (getValue(c1) + getValue(c2) == 21) {
        System.out.println("Blackjack!");
      } else {
        System.out.println("Total hand value: " + (getValue(c1) + getValue(c2)));
      }
    }
  }
}
