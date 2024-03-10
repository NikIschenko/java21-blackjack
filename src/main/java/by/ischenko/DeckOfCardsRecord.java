package by.ischenko;

public record DeckOfCardsRecord(
    int numberOfCards,
    boolean hasLogo,
    String brand,
    String color,
    boolean hasBox,
    int amountOfJokers
) { }