package codesquad.cardmatching.step1;

import codesquad.cardmatching.step1.domain.Coordinate;

public class Controller {

    private final GameService gameService = new GameService();

    public void run() {
        gameService.initGameCards(GameCardGenerator.newGameCards());
        GameCardsDTO gameCardDTO = gameService.getGameCardDTO();
        printInitialCardStatus(gameCardDTO);

        Coordinate firstCoordinates;
        Coordinate secondCoordinates;

        do {
            printInputRequestMessage();

            firstCoordinates = getFirstCoordinates();
            secondCoordinates = getSecondCoordinates(firstCoordinates);

            GameCardsDTO queriedStatus = gameService.getQueriedStatus(firstCoordinates, secondCoordinates);
            View.printCardStatus(queriedStatus);

            gameService.compareQueriedCards(firstCoordinates, secondCoordinates);
            GameCardsDTO comparedResult = gameService.getGameCardDTO();
            View.printCardStatus(comparedResult);

            gameService.increaseTrialNumber();
        } while (!gameService.isGameFinishCondition());
        View.printGameFinishMessage();
    }

    private void printInputRequestMessage() {
        int trialNumber = gameService.getTrialNumber();
        int countOfNotMatchedCards = gameService.getCountOfNotMatchedCards();
        View.printGameInfoAndRequestMessage(trialNumber, countOfNotMatchedCards);
    }

    private void printInitialCardStatus(GameCardsDTO gameCardDTO) {
        View.printCardStatus(gameCardDTO);
    }

    private Coordinate getFirstCoordinates() {
        try {
            Coordinate firstCoordinate = View.getFirstCoordinate();
            gameService.validateIsMatchedCardCoordinate(firstCoordinate);
            return firstCoordinate;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
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
            System.out.println(e.getMessage());
            return getSecondCoordinates(firstCoordinate);
        }
    }
}