package codesquad.cardmatching.step1;

import java.util.List;
import java.util.Map;

public class GameCardsDTO {
    private final Map<Integer, List<String >> gameCards;

    public static GameCardsDTO from(Map<Integer, List<String>> gameCardData) {
        return new GameCardsDTO(gameCardData);
    }

    private GameCardsDTO(Map<Integer, List<String>> gameCardData) {
        this.gameCards = gameCardData;
    }

    public Map<Integer, List<String>> getCards() {
        return gameCards;
    }
}