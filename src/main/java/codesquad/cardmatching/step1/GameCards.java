package codesquad.cardmatching.step1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GameCards {
    private final List<Card> cards;

    public static GameCards create() {
        return new GameCards();
    }

    private GameCards() {
        this.cards = getGameCards();
    }

    private List<Card> getGameCards() {
        List<Card> deck = getDeck();
        Collections.shuffle(deck);
        return deck.subList(0, 18);
    }

    private List<Card> getDeck() {
        return Stream.generate(GameCards::getCards)
                .limit(3)
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }


    private static List<Card> getCards() {
        return Arrays.stream(CardType.values())
                .map(Card::from)
                .collect(Collectors.toList());
    }
}