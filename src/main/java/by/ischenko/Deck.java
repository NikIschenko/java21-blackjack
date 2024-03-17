package by.ischenko;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lombok.Getter;

@Getter
public class Deck {

  private final List<PlayingCard> playingCards = createDeck();

  public void shuffle() {
    Collections.shuffle(playingCards);
  }

  private static List<PlayingCard> createDeck() {
    List<PlayingCard> deck = new ArrayList<>();
    String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
    String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

    for (String suit : suits) {
      for (String rank : ranks) {
        deck.add(new PlayingCard(rank, suit));
      }
    }
    return deck;
  }
}
