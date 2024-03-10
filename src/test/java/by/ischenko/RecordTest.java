package by.ischenko;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class RecordTest {

  private record DeckOfCardsRecord(
      int numberOfCards,
      boolean hasLogo,
      String brand
  ) { }


  @Test
  void recordVsLombokTest() {
    DeckOfCardsRecord recordDesk1 = new DeckOfCardsRecord(36, true,  "Acme");
    DeckOfCardsRecord recordDesk2 = new DeckOfCardsRecord(36, true,  "Acme");
    assertEquals(recordDesk1, recordDesk2);
    System.out.println(recordDesk1);
  }
}