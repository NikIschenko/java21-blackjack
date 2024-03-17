package by.ischenko;

import static java.lang.Integer.parseInt;
import java.util.Arrays;
import java.util.Set;

public class GameScorekeeper {

  private GameScorekeeper() {
  }

  public static int pointsInHand(PlayerHand playerHand) {
    return Arrays.stream(playerHand.cards())
        .mapToInt(GameScorekeeper::cardValue)
        .sum();
  }

  public static int pointsInPair(CardPair<Card> cardPair) {
    return switch (cardPair) {
      case CardPair<Card>(PlayingCard f, PlayingCard s) -> {
        System.out.println("Playing cards! First one: " + f + " Second one: " + s);
        yield cardValue(f) + cardValue(s);
      }
      case CardPair<Card>(UnoCard f, UnoCard s) -> {
        System.out.println("Uno cards! First one: " + f + " Second one: " + s);
        yield cardValue(f) + cardValue(s);
      }
      default -> throw new IllegalArgumentException("Unknown card type: " + cardPair);
    };
  }

  private static int cardValue(Card card) {
    return switch (card) {
      case UnoCard unoCard when isInteger(unoCard.getRank()) -> parseInt(unoCard.getRank());
      case UnoCard unoCard when !isInteger(unoCard.getRank()) ->
          10; // face cards are worth 10 points
      case PlayingCard playingCard when isInteger(playingCard.getRank()) ->
          parseInt(playingCard.getRank());
      case PlayingCard playingCard when "Ace".equals(playingCard.getRank()) -> 1;
      case PlayingCard playingCard when Set.of("Jack", "Queen", "King")
          .contains(playingCard.getRank()) -> 10;
      case null -> 0;
      default -> throw new IllegalArgumentException("Unknown card type: " + card);
    };
  }

  public static boolean isInteger(String str) {
    try {
      parseInt(str);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }
}
