package by.ischenko;

public record UnoCard(String rank, String color) implements Card {
  @Override
  public String getRank() {
    return rank;
  }
}