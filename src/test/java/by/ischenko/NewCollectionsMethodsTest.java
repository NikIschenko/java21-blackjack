package by.ischenko;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.SequencedCollection;
import java.util.SequencedSet;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;

class NewCollectionsMethodsTest {

  // newSequencedSetFromMap
  @Test
  void haveNoSenseJava17Test() { // hashMap -> hashSet
    Set<String> playerCardsSet = Collections.newSetFromMap(new HashMap<>());

    IntStream.range(0, 6)
        .mapToObj(i -> "Card" + i)
        .forEach(playerCardsSet::add);

    assertEquals(6, playerCardsSet.size());
  }

  @Test
  void doubtfulButOkayJava17Test() {
    Set<String> playerCardsSet = Collections.newSetFromMap(new WeakHashMap<>());

    IntStream.range(0, 6)
        .mapToObj(i -> "Card" + i)
        .forEach(playerCardsSet::add);

    assertEquals(6, playerCardsSet.size());
  }

  @Test
  void wouldBeCoolButNoJava17Test() {
    Map<String, Boolean> weakHashMap = new WeakHashMap<>();
    weakHashMap.put("Card1", true);
    weakHashMap.put("Card2", true);
    weakHashMap.put("Card3", true);
    weakHashMap.put("Card4", true);

    assertThrows(IllegalArgumentException.class, () -> Collections.newSetFromMap(weakHashMap));
  }

  @Test
  void sequencedSetWithStrictNumberOfElementsJava21Test() {
    SequencedSet<String> sequencedPlayerCardsSet = Collections.newSequencedSetFromMap(
        new LinkedHashMap<>() {
          protected boolean removeEldestEntry(Map.Entry<String, Boolean> e) {
            return this.size() > 5;
          }
        });

    IntStream.range(0, 16)
        .mapToObj(i -> "Card" + i)
        .forEach(sequencedPlayerCardsSet::add);

    assertEquals(5, sequencedPlayerCardsSet.size());
    assertEquals("Card11", sequencedPlayerCardsSet.getFirst());
    assertEquals("Card15", sequencedPlayerCardsSet.getLast());
  }


  // unmodifiableSequencedCollection
  @Test
  void unmodifiableSequencedCollectionTest() {
    List<String> deck = new ArrayList<>();
    deck.add("Card1");
    deck.add("Card2");
    deck.add("Card3");

    SequencedCollection<String> immutableDeck = Collections.unmodifiableSequencedCollection(deck);
    assertThrows(UnsupportedOperationException.class, () -> immutableDeck.addFirst("Card777"));
  }

  @Test
  void beAwareOfUnModifiableCollectionTest() {
    SequencedCollection<String> deck = new ArrayList<>();
    deck.add("Card1");
    deck.add("Card2");
    deck.add("Card3");

    SequencedCollection<String> immutableDeck = Collections.unmodifiableSequencedCollection(deck);
    deck.add("Card777");

    assertEquals(4, deck.size());
    assertEquals(4, immutableDeck.size());
  }

}
