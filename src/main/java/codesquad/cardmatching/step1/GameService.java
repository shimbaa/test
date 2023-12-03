package codesquad.cardmatching.step1;

import codesquad.cardmatching.step1.domain.GameCards;

public class GameService {

    private GameCards gameCards;

    public void initGameCards() {
        gameCards = GameCards.from(GameCardGenerator.newGameCards());
    }

    public GameCardsDTO getGameCardDTO() {
        return GameCardsDTO.from(gameCards.getCardStatus());
    }
}