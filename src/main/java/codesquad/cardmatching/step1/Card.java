package codesquad.cardmatching.step1;

import java.util.Objects;

public class Card {
    private final CardType cardType;

    public static Card from(CardType cardType) {
        return new Card(cardType);
    }

    private Card(CardType cardType) {
        this.cardType = cardType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Card card = (Card) o;
        return cardType == card.cardType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardType);
    }

    @Override
    public String toString() {
        return cardType.getValue();
    }
}