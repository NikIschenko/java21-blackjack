package by.ischenko;

import java.util.Arrays;

public record PlayerHand(Card... cards) {

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    PlayerHand that = (PlayerHand) o;
    return Arrays.equals(cards, that.cards);
  }

  @Override
  public int hashCode() {
    return Arrays.hashCode(cards);
  }

  @Override
  public String toString() {
    return "PlayerHand{" +
        "cards=" + Arrays.toString(cards) +
        '}';
  }
}
