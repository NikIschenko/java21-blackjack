package by.ischenko;

import lombok.Getter;

@Getter
public final class PlayingCard extends Card {

  private final String suit;

  public PlayingCard(String rank, String suit) {
    super(rank);
    this.suit = suit;
  }

  @Override
  public String getDescription() {
    return "Playing cards for playing games: " + CardGameType.valuesAsString();
  }
}
