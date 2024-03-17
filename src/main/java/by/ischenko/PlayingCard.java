package by.ischenko;

public record PlayingCard(String rank, String suit) implements Card {
  @Override
  public String getRank() {
    return rank;
  }
}