package by.ischenko;

import static by.ischenko.CardGameType.BLACKJACK;
import static by.ischenko.CardGameType.getGameDescription17;
import static by.ischenko.CardGameType.getGameDescription8;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class CardGameTypeTest {

  @Test
  void switch8vsSwitch17Test() {
    String expectedGameDescription = "Classic card games";
    String actualGameDescription17 = getGameDescription17(BLACKJACK);
    String actualGameDescription8 = getGameDescription8(BLACKJACK);

    assertEquals(expectedGameDescription, actualGameDescription8, actualGameDescription17);
  }
}