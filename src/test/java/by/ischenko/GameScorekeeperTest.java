package by.ischenko;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

class GameScorekeeperTest {

  @Test
  void testPointsInHandEmpty() {
    PlayerHand playerHand = new PlayerHand();
    assertEquals(0, GameScorekeeper.pointsInHand(playerHand));
  }

  @Test
  void testPointsInHandUnoCardsNumeric() {
    PlayerHand playerHand = new PlayerHand(
        new UnoCard("5", "red"),
        new UnoCard("3", "blue")
    );

    assertEquals(8, GameScorekeeper.pointsInHand(playerHand));
  }

  @Test
  void testPointsInHandUnoCardsFace() {
    PlayerHand playerHand = new PlayerHand(
        new UnoCard("Skip", "red"),
        new UnoCard("Reverse", "blue")
    );

    assertEquals(20, GameScorekeeper.pointsInHand(playerHand));
  }

  @Test
  void testPointsInHandPlayingCardsNumeric() {
    PlayerHand playerHand = new PlayerHand(
        new PlayingCard("5", "hearts"),
        new PlayingCard("3", "spades")
    );

    assertEquals(8, GameScorekeeper.pointsInHand(playerHand));
  }

  @Test
  void testPointsInHandPlayingCardsFace() {
    PlayerHand playerHand = new PlayerHand(
        new PlayingCard("King", "hearts"),
        new PlayingCard("Queen", "spades")
    );

    assertEquals(20, GameScorekeeper.pointsInHand(playerHand));
  }

  @Test
  void testPointsInHandMixedCards() {
    PlayerHand playerHand = new PlayerHand(
        new UnoCard("5", "red"),
        new PlayingCard("King", "hearts")
    );

    assertEquals(15, GameScorekeeper.pointsInHand(playerHand));
  }

  @Test
  void testPointsInHandNullValues() {
    PlayerHand playerHand = new PlayerHand(
        new UnoCard("5", "red"),
        null);

    assertEquals(5, GameScorekeeper.pointsInHand(playerHand));
  }

  @Test
  void testPointsInPairUnoCards() {
    CardPair<Card> cardPair = new CardPair<>(new UnoCard("5", "red"), new UnoCard("3", "blue"));
    assertEquals(8, GameScorekeeper.pointsInPair(cardPair));
  }

  @Test
  void testPointsInPairPlayingCards() {
    CardPair<Card> cardPair = new CardPair<>(new PlayingCard("5", "hearts"),
        new PlayingCard("3", "spades"));
    assertEquals(8, GameScorekeeper.pointsInPair(cardPair));
  }

  @Test
  void testPointsInPairMixedCards() {
    CardPair<Card> cardPair = new CardPair<>(new UnoCard("5", "red"),
        new PlayingCard("3", "spades"));
    assertThrows(IllegalArgumentException.class, () -> GameScorekeeper.pointsInPair(cardPair));
  }

  @Test
  void testPointsInPairNullValues() {
    CardPair<Card> cardPair = new CardPair<>(new UnoCard("5", "red"), null);
    assertThrows(IllegalArgumentException.class, () -> GameScorekeeper.pointsInPair(cardPair));
  }
}