package codesquad.cardmatching.step1;

import codesquad.cardmatching.step1.domain.Card;
import codesquad.cardmatching.step1.domain.CardStatus;
import codesquad.cardmatching.step1.domain.Coordinate;
import codesquad.cardmatching.step1.domain.GameCards;
import java.util.List;

public class GameService {

    private static final String INVALID_COORDINATE_BY_MATCHED_CARD = "이미 제거된 카드의 좌표가 아닌 값을 입력해주세요";
    private static final String SAME_COORDINATE = "같은 좌표를 입력할 수 없습니다.";
    private GameCards gameCards;
    private int trialNumber = 1;

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

    public boolean isGameFinishCondition() {
        return !gameCards.isMatchingCardsExist() || gameCards.isAllCardsMatched();
    }

    public void compareQueriedCards(Coordinate first, Coordinate second) {
        Card firstCard = gameCards.getCardByCoordinate(first);
        Card secondCard = gameCards.getCardByCoordinate(second);
        compare(firstCard, secondCard);
    }

    public int getCountOfNotMatchedCards() {
        return gameCards.getCountOfNotMatchedCards();
    }

    public int getTrialNumber() {
        return trialNumber;
    }

    public void increaseTrialNumber() {
        this.trialNumber += 1;
    }

    public void validateIsSameCoordinate(Coordinate first, Coordinate second) {
        if (first.equals(second)) {
            throw new IllegalArgumentException(SAME_COORDINATE);
        }
    }

    public void validateIsMatchedCardCoordinate(Coordinate coordinate) {
        if (isMatchedCardCoordinate(coordinate)) {
            throw new IllegalArgumentException(INVALID_COORDINATE_BY_MATCHED_CARD);
        }
    }

    private boolean isMatchedCardCoordinate(Coordinate coordinate) {
        Card card = gameCards.getCardByCoordinate(coordinate);
        return card.getStatus().equals(CardStatus.MATCHED.toString());
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