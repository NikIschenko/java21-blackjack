package by.ischenko;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public abstract sealed class Card permits PlayingCard, UnoCard {

  private final String rank;

  public abstract String getDescription();
}
