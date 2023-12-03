package codesquad.cardmatching.step1;

import static org.assertj.core.api.Assertions.*;

import codesquad.cardmatching.step1.domain.Card;
import codesquad.cardmatching.step1.domain.CardType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CardTest {

    @DisplayName("같은 타입의 카드는 동일한 카드로 취급되어야 한다")
    @Test
    void sameCardTypeEquals() {
        Card card1 = Card.from(CardType.ONE);
        Card card2 = Card.from(CardType.ONE);

        assertThat(card1).isEqualTo(card2);
    }

    @DisplayName("다른 타입의 카드는 다른 카드로 취급되어야 한다")
    @Test
    void differentCardTypeNotEquals() {
        Card card1 = Card.from(CardType.ONE);
        Card card2 = Card.from(CardType.TWO);

        assertThat(card1).isNotEqualTo(card2);
    }
}
