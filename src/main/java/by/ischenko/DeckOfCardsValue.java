package by.ischenko;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class DeckOfCardsValue {
  int numberOfCards;
  boolean hasLogo;
  String brand;
  String color;
  boolean hasBox;
  int amountOfJokers;
}
