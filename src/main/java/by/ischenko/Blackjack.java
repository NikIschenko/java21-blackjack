package by.ischenko;

public class Blackjack {
  private Blackjack() {}

  public static int getValue(PlayingCard card) {
    return switch (card.getRank()) {
      case "Ace" -> 11;
      case "2", "3", "4", "5", "6", "7", "8", "9" -> Integer.parseInt(card.getRank());
      case "10", "Jack", "Queen", "King" -> 10;
      default -> 0;
    };
  }
}
