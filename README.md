# Java's Blackjack and 21 on hand
![img.png](.readmd/header.png)

*This repository contains examples of the important new features introduced in between Java 17 and Java 21.
Let's explore these features and how to switch between them using Git branches.*


## Java 17: what's ~~new~~ old features

### 🔡 JEP 378: ”””Text Blocks”””
The Java text block feature, introduced in Java 15 and later, allows you to create multi-line string literals in a more readable and efficient way. Here are the key points about text blocks:

#### Syntax:
Text blocks start with three double-quote marks (""") followed by optional whitespaces and a newline.
The content of the text block can span multiple lines without the need for explicit escape characters or concatenation.
#### Example:
```java
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
```
#### Indentation Handling:
* Text blocks allow proper indentation.
* The compiler checks for the minimum indentation in all non-empty lines.
* The entire text block is shifted to the left based on this minimum indentation.
* The (base) indentation and the first newline are not included in the resulting String.
#### Escaping:
* Inside text blocks, double-quotes don’t need to be escaped.
* You can even use three double-quotes within a text block by escaping one of them.
* Text blocks are particularly useful for writing multi-line strings such as HTML, JSON, SQL queries, or any other structured text. They improve code readability and eliminate the need for manual line breaks and concatenation. 🌟📝
#### Branch
`git checkout java17/text-blocks`
#### Links
JEP 378: https://openjdk.org/jeps/378

### ⚕️JEP 406: Pattern matching for switch (Preview)
The Pattern Matching for switch feature, introduced in Java SE 17, enhances the Java programming language by allowing pattern matching for switch expressions and statements. This feature provides a more concise and readable syntax for checking the type of an object at runtime. Here are the key points:
#### Goals:
* Expand the expressiveness and applicability of switch expressions and statements by allowing patterns to appear in case labels.
* Relax the historical null-hostility of switch when desired.
* Introduce two new kinds of patterns: guarded patterns (to refine pattern matching logic with arbitrary boolean expressions) and parenthesized patterns (to resolve parsing ambiguities).
* Ensure that existing switch expressions and statements continue to compile with no changes and execute with identical semantics.
* Do not introduce a new switch-like construct separate from the traditional switch.
* Maintain consistent behavior regardless of whether case labels are patterns or traditional constants.
#### Motivation:
* Prior to this enhancement, switch statements were limited to exact equality tests against constants.
* With pattern matching, we can now test a variable against multiple possibilities, taking specific actions based on the matched pattern.
#### Example:
```java
  public static String getGameDescription17(CardGameType gameType) {
    return switch (gameType) {
      case POKER, BLACKJACK -> "Classic card games";
      case BRIDGE, RUMMY -> "Strategy card games";
      case SOLITAIRE, HEARTS, SPADES -> "Single-player card games";
      case EUCHRE, CANASTA, CRAZY_EIGHTS -> "Social card games";
      case GIN_RUMMY -> "Rummy variant";
      case WAR -> "Simple card battle game";
      case GO_FISH -> "Children's card game";
      case CASSINO, PINOCHLE -> "Trick-taking games";
      case CRIBBAGE -> "Unique scoring card game";
      case TRICK_TAKING, TRUMPS -> "General trick-taking games";
      default -> "Other card games";
    };
  }
```
#### Branch
`git checkout java17/switch`
#### Links
JEP 406: https://openjdk.org/jeps/406

### 📹 JEP 395: Record vs Lombok 🪄
When it comes to creating data classes in Java, both Java Records and Lombok offer solutions to reduce boilerplate code. However, they serve different purposes and have distinct features. Let’s explore their differences:

#### Java Records
##### Use Case
* Best suited for simple data transport objects, especially where immutability is desired.
* Designed as transparent carriers for immutable data.
* Ideal for scenarios where you need concise, read-only data structures.
##### Features
* Automatically generates essential methods like equals, hashCode, and toString.
* Concise syntax for defining data fields.
* Immutable by default.
* Well-suited for small, straightforward use-cases.
#### Example:
```java
public record DeckOfCardsRecord(
    int numberOfCards,
    boolean hasLogo,
    String brand,
    String color,
    boolean hasBox,
    int amountOfJokers
) { }
```
### Lombok
#### Use Case:
* More flexible, suitable for both mutable and immutable classes.
* Offers a wider range of features beyond what records provide.
* Allows customization of getter names, access levels, and return types.
#### Features:
* `@Value`: Creates immutable objects with minimal boilerplate.
* `@Getter`, `@Setter`: Customizable getter and setter methods.
* `@Builder`: Simplifies object creation with a fluent builder pattern.
* `@Data`: Combines `@Getter`, `@Setter`, `@EqualsAndHashCode`, and `@ToString`.
#### Example:
```java
@Value
@Builder
public class DeckOfCardsValue {
  int numberOfCards;
  boolean hasLogo;
  String brand;
  String color;
  boolean hasBox;
  int amountOfJokers;
}
```

### 👥JEP 394: Pattern Matching ...for instanceof
Pattern matching for instanceof is a Java 17 feature that allows you to test and assign an object to a variable of a specific type in one step. This feature simplifies the code and makes it more readable and robust. For example, instead of writing:
```java
if (obj instanceof DeckOfCardsValue) {
  DeckOfCardsValue deckOfCardsValue = (DeckOfCardsValue) obj;
  assertEquals(36, deckOfCardsValue.getNumberOfCards());
}
```
You can write:
```java
if (obj instanceof DeckOfCardsValue deckOfCardsValue) {
  assertEquals(36, deckOfCardsValue.getNumberOfCards());
}
```
#### Branch
`git checkout java17/pattern-matching`
#### Links
JEP 394: https://openjdk.org/jeps/394

### 👩‍👧‍👦JEP 409: Sealed classes… or final with exceptions
Sealed classes are a Java 17 feature that allows you to restrict which classes or interfaces can extend or implement a class or an interface. This feature enables more fine-grained inheritance control and supports future directions in pattern matching. For example, you can use sealed classes to model a fixed set of kinds of values in a domain, such as shapes or celestial objects.
To declare a sealed class or interface, you need to use the sealed modifier and specify the permitted subclasses or subinterfaces in the permits clause. For example:
```java
@Getter
@RequiredArgsConstructor
public abstract sealed class Card permits PlayingCard, UnoCard {
  private final String rank;
  public abstract String getDescription();
}
```
This means that only `PlayingCard` and `UnoCard` can extend `Card`. The permitted subclasses or subinterfaces must be declared in the same module or package as the sealed class or interface, and they must have one of the following modifiers:
* `final`: The class or interface cannot have any further subclasses or subinterfaces.
* `sealed`: The class or interface can have a restricted set of subclasses or subinterfaces, specified by its own permits clause.
* `non-sealed`: The class or interface can have any subclasses or subinterfaces, without any restrictions.
#### Branch
`git checkout java17/sealed`
#### Links
JEP 409: https://openjdk.org/jeps/409


