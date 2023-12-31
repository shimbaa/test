package codesquad.cardmatching.step1.domain;

import java.util.Objects;

public class Card {
    private final CardType cardType;

    private CardStatus cardStatus;

    public static Card from(CardType cardType) {
        return new Card(cardType);
    }

    private Card(CardType cardType) {
        this.cardType = cardType;
        this.cardStatus = CardStatus.NOT_MATCHED;
    }

    public String getStatus() {
        return cardStatus.toString();
    }

    public String getCardType() {
        return cardType.getValue();
    }

    public void changeCardStatusToMatched() {
        this.cardStatus = CardStatus.MATCHED;
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
}