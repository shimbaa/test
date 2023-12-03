package codesquad.cardmatching.step1;

import java.util.List;
import java.util.Map;

public class GameCardsDTO {
    private final Map<Integer, List<Card>> gameCards;

    public static GameCardsDTO from(Map<Integer, List<Card>> gameCards) {
        return new GameCardsDTO(gameCards);
    }

    private GameCardsDTO(Map<Integer, List<Card>> gameCards) {
        this.gameCards = gameCards;
    }

    public List<Card> getFirstRow() {
        return gameCards.get(Row.FIRST.getValue());
    }

    public List<Card> getSecondRow() {
        return gameCards.get(Row.SECOND.getValue());
    }

    public List<Card> getThirdRow() {
        return gameCards.get(Row.THIRD.getValue());
    }
}