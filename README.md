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