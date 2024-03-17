package by.ischenko;

public sealed interface Card permits PlayingCard {
  String getRank();

}
