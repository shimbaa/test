package codesquad.cardmatching.step1;

import codesquad.cardmatching.step1.domain.Coordinate;
import codesquad.cardmatching.step1.util.GameCardGenerator;

public class Controller {

    private final GameService gameService = new GameService();

    public void run() {
        gameService.initGameCards(GameCardGenerator.newGameCards());
        printInitialCardStatus();
        playUntilGameFinishCondition();
        View.printGameFinishMessage();
    }

    private void printInitialCardStatus() {
        GameCardsDTO gameCardDTO = gameService.getGameCardDTO();
        View.printCardStatus(gameCardDTO);
    }

    private void playUntilGameFinishCondition() {
        do {
            printInputRequestMessage();

            Coordinate firstCoordinates = getFirstCoordinates();
            Coordinate secondCoordinates = getSecondCoordinates(firstCoordinates);

            printQueriedCards(firstCoordinates, secondCoordinates);
            compareCards(firstCoordinates, secondCoordinates);
            gameService.increaseTrialNumber();
        } while (!gameService.isGameFinishCondition());
    }

    private void printInputRequestMessage() {
        int trialNumber = gameService.getTrialNumber();
        int countOfNotMatchedCards = gameService.getCountOfNotMatchedCards();
        View.printGameInfoAndRequestMessage(trialNumber, countOfNotMatchedCards);
    }

    private void printQueriedCards(Coordinate firstCoordinates, Coordinate secondCoordinates) {
        GameCardsDTO queriedStatus = gameService.getQueriedStatus(firstCoordinates, secondCoordinates);
        View.printCardStatus(queriedStatus);
    }

    private void compareCards(Coordinate firstCoordinates, Coordinate secondCoordinates) {
        gameService.compareQueriedCards(firstCoordinates, secondCoordinates);
        GameCardsDTO comparedResult = gameService.getGameCardDTO();
        View.printCardStatus(comparedResult);
    }

    private Coordinate getFirstCoordinates() {
        try {
            Coordinate firstCoordinate = View.getFirstCoordinate();
            gameService.validateIsMatchedCardCoordinate(firstCoordinate);
            return firstCoordinate;
        } catch (IllegalArgumentException e) {
            View.printErrorMessage(e.getMessage());
            return getFirstCoordinates();
        }
    }

    private Coordinate getSecondCoordinates(Coordinate firstCoordinate) {
        try {
            Coordinate secondCoordinate = View.getSecondCoordinate();
            gameService.validateIsMatchedCardCoordinate(secondCoordinate);
            gameService.validateIsSameCoordinate(firstCoordinate, secondCoordinate);
            return secondCoordinate;
        } catch (IllegalArgumentException e) {
            View.printErrorMessage(e.getMessage());
            return getSecondCoordinates(firstCoordinate);
        }
    }
}