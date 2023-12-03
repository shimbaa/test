package codesquad.cardmatching.step1.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GameCards {
    private final Map<Integer, List<Card>> cards;

    public static GameCards from(List<Card> gameCards) {
        return new GameCards(gameCards);
    }

    private GameCards(List<Card> gameCards) {
        this.cards = new HashMap<>();
        initGameCards(gameCards);
    }

    public Map<Integer, List<String>> getCardStatus() {
        return cards.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().stream()
                                .map(Card::getStatus)
                                .collect(Collectors.toList())
                ));
    }

    private void initGameCards(List<Card> gameCards) {
        cards.put(Row.FIRST.getValue(), getFirstRow(gameCards));
        cards.put(Row.SECOND.getValue(), getSecondRow(gameCards));
        cards.put(Row.THIRD.getValue(), getThirdRow(gameCards));
    }

    private List<Card> getFirstRow(List<Card> gameCards) {
        return gameCards.subList(0, 6);
    }

    private List<Card> getSecondRow(List<Card> gameCards) {
        return gameCards.subList(6, 12);
    }

    private List<Card> getThirdRow(List<Card> gameCards) {
        return gameCards.subList(12, 18);
    }
}