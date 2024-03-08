package by.ischenko;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CardDeckTest {

  @Test
  void testDeserializeCardDeck() throws IOException {
    String cards = """
            {
                "deck": "STANDARD",
                "cards": [
                    {
                        "rank": "TEN",
                        "suit": "DIAMONDS"
                    },
                    {
                        "rank": "KING",
                        "suit": "SPADES"
                    }
                ]
            }
            """;

    ObjectMapper objectMapper = new ObjectMapper();
    CardDeck cardDeck = objectMapper.readValue(cards, CardDeck.class);

    assertEquals(DeckType.STANDARD, cardDeck.getDeck());

    List<Card> expectedCards = List.of(
        new Card(Rank.TEN, Suit.DIAMONDS),
        new Card(Rank.KING, Suit.SPADES)
    );
    assertEquals(expectedCards, cardDeck.getCards());
  }
}
