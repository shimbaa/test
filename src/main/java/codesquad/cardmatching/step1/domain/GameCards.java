package codesquad.cardmatching.step1.domain;

import java.util.Arrays;
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

    public Card getCardByCoordinate(Coordinate coordinate) {
        return cards.get(coordinate.getRow()).get(coordinate.getColumn());
    }

    public boolean isMatchingCardsExist() {
        List<Card> notMatchedCards = getNotMatchedCards();
        long count = getCountOfPair(notMatchedCards);
        return count != 0;
    }

    public boolean isAllCardsMatched() {
        List<Card> notMatchedCards = getNotMatchedCards();
        return notMatchedCards.size() == 0;
    }

    private List<Card> getNotMatchedCards() {
        return cards.values().stream()
                .flatMap(List::stream)
                .filter(card -> card.getStatus().equals(CardStatus.NOT_MATCHED.toString()))
                .toList();
    }

    private long getCountOfPair(List<Card> notMatchedCards) {
        return Arrays.stream(CardType.values())
                .map(cardType -> notMatchedCards.stream()
                        .filter(card -> card.getCardType().equals(cardType.getValue()))
                        .count())
                .filter(cardCount -> cardCount >= 2)
                .count();
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