package by.ischenko;

import lombok.Getter;

@Getter
public final class UnoCard extends Card {

  private final String color;

  public UnoCard(String rank, String color) {
    super(rank);
    this.color = color;
  }

  @Override
  public String getDescription() {
    return "Playing cards for playing Uno";
  }
}
