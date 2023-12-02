package codesquad.cardmatching.step1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameCards {
    private static final int FIRST_ROW = 1;
    private static final int SECOND_ROW = 2;
    private static final int THIRD_ROW = 3;
    private final Map<Integer, List<Card>> cards;

    public static GameCards from(List<Card> gameCards) {
        return new GameCards(gameCards);
    }

    private GameCards(List<Card> gameCards) {
        this.cards = new HashMap<>();
        initGameCards(gameCards);
    }

    private void initGameCards(List<Card> gameCards) {
        cards.put(FIRST_ROW, getFirstRow(gameCards));
        cards.put(SECOND_ROW, getSecondRow(gameCards));
        cards.put(THIRD_ROW, getThirdRow(gameCards));
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