package by.ischenko;

public sealed interface Card permits UnoCard, PlayingCard {
  String getRank();

}
