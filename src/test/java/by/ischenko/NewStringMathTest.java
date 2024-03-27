package by.ischenko;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

class NewStringMathTest {

  private static final String BLACKJACK = """
      Blackjack, also known as 21, is an immensely popular card game played worldwide,
      where players aim to achieve a hand value as close to 21 as possible without exceeding it,
      competing against the dealer""";

  // String
  @Test
  void indexOfInBetweenTest() {
    int positionOf21 = BLACKJACK.indexOf("21", 30, BLACKJACK.length());

    assertEquals(135, positionOf21);
  }

  @Test
  void splitWithDelimitersTest() {
    String[] parts = BLACKJACK.split(",", 3);
    String[] partsWithDelimiters = BLACKJACK.splitWithDelimiters(",", 3);

    assertEquals(3, parts.length);
    assertEquals(5, partsWithDelimiters.length);

    Arrays.stream(parts).forEach(System.out::println);
    Arrays.stream(partsWithDelimiters).forEach(System.out::println);
  }

  // StringBuilder
  @Test
  void stringAndStreamJava17Test() {
    String repeated = Stream.generate(() -> "Blackjack, ")
        .limit(3)
        .collect(Collectors.joining("", "♠️♣️♥️♦️", "♠️♣️♥️♦️"));

    assertEquals("♠️♣️♥️♦️Blackjack, Blackjack, Blackjack, ♠️♣️♥️♦️", repeated);
  }

  @Test
  void stringBuilderRepeatJava21Test() {
    String repeated = new StringBuilder("♠️♣️♥️♦️")
        .repeat("Blackjack, ", 3)
        .append("♠️♣️♥️♦️")
        .toString();

    assertEquals("♠️♣️♥️♦️Blackjack, Blackjack, Blackjack, ♠️♣️♥️♦️", repeated);
  }

  // Character
  @Test
  void isEmojiTest() {
    assertTrue(Character.isEmoji("♠️".codePointAt(0)));
    assertTrue(Character.isEmoji("♣️".codePointAt(0)));
    assertTrue(Character.isEmoji("♥️".codePointAt(0)));
    assertTrue(Character.isEmoji("♦️".codePointAt(0)));
    assertFalse(Character.isEmoji("B".codePointAt(0)));
  }

  // Math
  @Test
  /*    if (value < min) {
   *       value = min;
   *     } else if (value > max) {
   *       value = max;
   *     }
   */
  void clampTest() {

    int min = 10;
    int max = 20;

    assertEquals(10, Math.clamp(5, min, max));
    assertEquals(10, Math.clamp(10, min, max));
    assertEquals(15, Math.clamp(15, min, max));
    assertEquals(20, Math.clamp(25, min, max));
  }
}
