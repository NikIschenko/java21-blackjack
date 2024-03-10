package by.ischenko;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class SealedClassesTest {
  @Test
  void sealedClassTest() {
    Card aceOfSpades = new PlayingCard("Ace", "Spades");
    Card redSkip = new UnoCard("Skip", "Red");

    Class<? extends Card> playingCardClass = takeHeir(aceOfSpades);
    Class<? extends Card> unoCardClass = takeHeir(redSkip);

    assertEquals(PlayingCard.class, playingCardClass);
    assertEquals(UnoCard.class, unoCardClass);
  }

  private Class<? extends Card> takeHeir(Card card) {
    if (card instanceof PlayingCard playingCard) {
      System.out.println(playingCard.getDescription());
      return playingCard.getClass();
    } else if (card instanceof UnoCard unoCard) {
      System.out.println(unoCard.getDescription());
      return unoCard.getClass();
    }
    return Card.class;
  }
}
