package by.ischenko;

import java.util.Arrays;
import java.util.Objects;

public record PlayingCard(String rank, String suit) implements Card, Comparable<PlayingCard> {
  @Override
  public String getRank() {
    return rank;
  }

  @Override
  public int compareTo(PlayingCard other) {
    String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
    String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

    int suitComparison = Integer.compare(
        Arrays.asList(suits).indexOf(this.suit), Arrays.asList(suits).indexOf(other.suit));
    if (suitComparison != 0) {
      return suitComparison;
    }

    return Integer.compare(Arrays.asList(ranks).indexOf(this.rank), Arrays.asList(ranks).indexOf(other.rank));
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    PlayingCard that = (PlayingCard) o;
    return Objects.equals(rank, that.rank) && Objects.equals(suit, that.suit);
  }

  @Override
  public int hashCode() {
    return Objects.hash(rank, suit);
  }
}