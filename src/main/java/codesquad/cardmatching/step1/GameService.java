package codesquad.cardmatching.step1;

import codesquad.cardmatching.step1.domain.Card;
import codesquad.cardmatching.step1.domain.Coordinate;
import codesquad.cardmatching.step1.domain.GameCards;
import java.util.List;

public class GameService {

    private GameCards gameCards;

    public void initGameCards(List<Card> cards) {
        gameCards = GameCards.from(cards);
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

    public boolean isMatchingCardsExist() {
        return gameCards.isMatchingCardsExist();
    }

    public void compareQueriedCards(Coordinate first, Coordinate second) {
        Card firstCard = gameCards.getCardByCoordinate(first);
        Card secondCard = gameCards.getCardByCoordinate(second);
        compare(firstCard, secondCard);
    }

    private void compare(Card firstCard, Card secondCard) {
        if (firstCard.equals(secondCard)) {
            firstCard.changeCardStatusToMatched();
            secondCard.changeCardStatusToMatched();
        }
    }

    private String getCardTypeByCoordinate(Coordinate coordinate) {
        Card card = gameCards.getCardByCoordinate(coordinate);
        return card.getCardType();
    }

    private void convertStatusToCardType(GameCardsDTO dto, Coordinate coordinate, String cardType) {
        dto.getCards().get(coordinate.getRow())
                .set(coordinate.getColumn(), cardType);
    }
}