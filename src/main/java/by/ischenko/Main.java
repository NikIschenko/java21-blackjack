package by.ischenko;

import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

  public static void main(String[] args) {
    List<Card> sampleCards = List.of(
        new Card(Rank.ACE, Suit.HEARTS),
        new Card(Rank.TEN, Suit.DIAMONDS),
        new Card(Rank.KING, Suit.SPADES)
    );

    CardDeck standardDeck = new CardDeck(DeckType.STANDARD, sampleCards);

    log.info("Deck type: " + standardDeck.getDeck());
    log.info("Cards:");
    for (Card card : standardDeck.getCards()) {
      log.info(card.getRank() + " of " + card.getSuit());
    }
  }
}