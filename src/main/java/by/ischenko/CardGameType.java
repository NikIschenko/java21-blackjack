package by.ischenko;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum CardGameType {
  POKER, BLACKJACK, BRIDGE, RUMMY, SOLITAIRE, HEARTS, SPADES,
  EUCHRE, CANASTA, CRAZY_EIGHTS, GIN_RUMMY, WAR, GO_FISH,
  CASSINO, PINOCHLE, CRIBBAGE, TRICK_TAKING, TRUMPS, OTHER;

  public static String getGameDescription(CardGameType gameType) {
    return switch (gameType) {
      case POKER, BLACKJACK -> "Classic card games";
      case BRIDGE, RUMMY -> "Strategy card games";
      case SOLITAIRE, HEARTS, SPADES -> "Single-player card games";
      case EUCHRE, CANASTA, CRAZY_EIGHTS -> "Social card games";
      case GIN_RUMMY -> "Rummy variant";
      case WAR -> "Simple card battle game";
      case GO_FISH -> "Children's card game";
      case CASSINO, PINOCHLE -> "Trick-taking games";
      case CRIBBAGE -> "Unique scoring card game";
      case TRICK_TAKING, TRUMPS -> "General trick-taking games";
      default -> "Other card games";
    };
  }

  public static String valuesAsString() {
    return Arrays.stream(CardGameType.values())
        .map(Enum::name)
        .collect(Collectors.joining(", "));
  }
}

