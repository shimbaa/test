package codesquad.cardmatching.step1;

import codesquad.cardmatching.step1.domain.Coordinate;
import codesquad.cardmatching.step1.domain.GameCards;

public class GameService {

    private GameCards gameCards;

    public void initGameCards() {
        gameCards = GameCards.from(GameCardGenerator.newGameCards());
    }

    public GameCardsDTO getGameCardDTO() {
        return GameCardsDTO.from(gameCards.getCardStatus());
    }

    public GameCardsDTO getQueriedStatus(Coordinate first, Coordinate second) {
        String firstCardType = getCardTypeByCoordinate(first);
        String secondCardType = getCardTypeByCoordinate(second);

        GameCardsDTO dto = getGameCardDTO();
        convertStatusToCardType(dto, first, firstCardType);
        convertStatusToCardType(dto, second, secondCardType);
        return dto;
    }

    private String getCardTypeByCoordinate(Coordinate coordinate) {
        return gameCards.getCardTypeByCoordinate(coordinate);
    }

    private void convertStatusToCardType(GameCardsDTO dto, Coordinate coordinate, String cardType) {
        dto.getCards().get(coordinate.getRow())
                .set(coordinate.getColumn(), cardType);
    }
}