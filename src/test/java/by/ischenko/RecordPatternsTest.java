package by.ischenko;

import org.junit.jupiter.api.Test;

class RecordPatternsTest {


  @Test
  void recordPatternsJava17Test() {
    Object card1 = new Card("Hearts", 10);
    Object card2 = new Card("Spades", 8);

    Object playerHand = new PlayerHand(card1, card2);
    if (playerHand instanceof PlayerHand ph) {
      if (ph.firstCard() instanceof Card c1 && ph.secondCard() instanceof Card c2) {
        
      }
      System.out.println("First card: " + c1);
      System.out.println("Second card: " + c2);
      if (c1.value() + c2.value() == 21) {
        System.out.println("Blackjack!");
      } else {
        System.out.println("Total hand value: " + (c1.value() + c2.value()));
      }
    }
  }
}
