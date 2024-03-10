package by.ischenko;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class LombokVsRecordTest {

  @Test
  void recordVsLombokTest() {
    DeckOfCardsRecord recordDesk = new DeckOfCardsRecord(36, true, "Bom-bom", "red", true, 2);

    DeckOfCardsValue lombokDesk = DeckOfCardsValue.builder()
        .numberOfCards(36)
        .hasLogo(true)
        .amountOfJokers(2)
        .brand("Bom-bom")
        .color("red")
        .hasBox(true)
        .build();

    assertEquals(recordDesk.numberOfCards(), lombokDesk.getNumberOfCards());
  }
}