package by.ischenko;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.SequencedCollection;
import java.util.SortedSet;
import java.util.TreeSet;
import org.junit.jupiter.api.Test;

class DeckTest {

  @Test
  void getFirstGetLast17Test() {
    Deck deck = new Deck();
    List<PlayingCard> listCollection = new ArrayList<>(deck.getPlayingCards());
    Deque<PlayingCard> dequeCollection = new ArrayDeque<>(deck.getPlayingCards());
    SortedSet<PlayingCard> sortedSetCollection = new TreeSet<>(deck.getPlayingCards());
    LinkedHashSet<PlayingCard> linkedHashSetCollection = new LinkedHashSet<>(deck.getPlayingCards());

   // Get the first card from each collection
    PlayingCard firstCardList = listCollection.get(0);
    PlayingCard firstCardDeque = dequeCollection.getFirst();
    PlayingCard firstCardSortedSet = sortedSetCollection.first();
    PlayingCard firstCardLinkedHashSet = linkedHashSetCollection.iterator().next();

    // Assert that all first cards are equal
    assert firstCardList.equals(firstCardDeque) &&
        firstCardList.equals(firstCardSortedSet) &&
        firstCardList.equals(firstCardLinkedHashSet) :
        "First cards are not equal";

    // Get the last card from each collection
    PlayingCard lastCardList = listCollection.get(listCollection.size() - 1);
    PlayingCard lastCardDeque = dequeCollection.getLast();
    PlayingCard lastCardSortedSet = sortedSetCollection.last();
    PlayingCard lastCardLinkedHashSet = linkedHashSetCollection.stream()
        .reduce((first, second) -> second)
        .orElse(null);

    // Assert that all last cards are equal
    assert lastCardList.equals(lastCardDeque) &&
        lastCardList.equals(lastCardSortedSet) &&
        lastCardList.equals(lastCardLinkedHashSet) :
        "Last cards are not equal";
  }

  @Test
  void getFirstGetLast21Test() {
    Deck deck = new Deck();
    SequencedCollection<PlayingCard> listCollection = new ArrayList<>(deck.getPlayingCards());
    SequencedCollection<PlayingCard> dequeCollection = new ArrayDeque<>(deck.getPlayingCards());
    SequencedCollection<PlayingCard> sortedSetCollection = new TreeSet<>(deck.getPlayingCards());
    SequencedCollection<PlayingCard> linkedHashSetCollection = new LinkedHashSet<>(deck.getPlayingCards());

    // Get the first card from each collection
    PlayingCard firstCardList = listCollection.getFirst();
    PlayingCard firstCardDeque = dequeCollection.getFirst();
    PlayingCard firstCardSortedSet = sortedSetCollection.getFirst();
    PlayingCard firstCardLinkedHashSet = linkedHashSetCollection.getFirst();

    assert firstCardList.equals(firstCardDeque) &&
        firstCardList.equals(firstCardSortedSet) &&
        firstCardList.equals(firstCardLinkedHashSet) :
        "First cards are not equal";

    PlayingCard lastCardList = listCollection.getLast();
    PlayingCard lastCardDeque = dequeCollection.getLast();
    PlayingCard lastCardSortedSet = sortedSetCollection.getLast();
    PlayingCard lastCardLinkedHashSet = linkedHashSetCollection.getLast();

    assert lastCardList.equals(lastCardDeque) &&
        lastCardList.equals(lastCardSortedSet) &&
        lastCardList.equals(lastCardLinkedHashSet) :
        "Last cards are not equal";
  }
}