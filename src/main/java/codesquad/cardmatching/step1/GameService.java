package codesquad.cardmatching.step1;

public class GameService {

    private GameCards gameCards;

    public void initGameCards() {
        gameCards = GameCards.from(GameCardGenerator.newGameCards());
    }

    public GameCardsDTO getGameCardDTO() {
        return gameCards.getGameCardsDTO();
    }
}