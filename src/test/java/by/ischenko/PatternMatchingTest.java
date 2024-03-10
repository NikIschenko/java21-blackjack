package by.ischenko;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class PatternMatchingTest {

  @Test
  void beforeTest() {
    Object obj = DeckOfCardsValue.builder()
        .numberOfCards(36)
        .hasLogo(true)
        .amountOfJokers(2)
        .brand("Acme")
        .hasBox(true)
        .color("RED")
        .build();
    if (obj instanceof DeckOfCardsValue) {
      DeckOfCardsValue deckOfCardsValue = (DeckOfCardsValue) obj;
      assertEquals(36, deckOfCardsValue.getNumberOfCards());
    }
  }

  @Test
  void afterTest() {
    Object obj = DeckOfCardsValue.builder()
        .numberOfCards(36)
        .hasLogo(true)
        .amountOfJokers(2)
        .brand("Acme")
        .hasBox(true)
        .color("RED")
        .build();
    if (obj instanceof DeckOfCardsValue deckOfCardsValue) {
      assertEquals(36, deckOfCardsValue.getNumberOfCards());
    }
  }
}