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
