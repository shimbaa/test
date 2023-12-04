package codesquad.cardmatching.step1;

import codesquad.cardmatching.step1.domain.Coordinate;

public class Controller {

    private final GameService gameService = new GameService();

    public void run() {
        gameService.initGameCards(GameCardGenerator.newGameCards());
        GameCardsDTO gameCardDTO = gameService.getGameCardDTO();
        printInitialCardStatus(gameCardDTO);

        do {
            printInputRequestMessage();

            Coordinate firstCoordinates = getFirstCoordinates();
            Coordinate secondCoordinates = getSecondCoordinates();

            GameCardsDTO queriedStatus = gameService.getQueriedStatus(firstCoordinates, secondCoordinates);
            View.printCardStatus(queriedStatus);

            gameService.compareQueriedCards(firstCoordinates, secondCoordinates);
            GameCardsDTO comparedResult = gameService.getGameCardDTO();
            View.printCardStatus(comparedResult);

            gameService.increaseTrialNumber();
        } while (!gameService.isGameFinishCondition());
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
            return View.getFirstCoordinate();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getFirstCoordinates();
        }
    }

    private Coordinate getSecondCoordinates() {
        try {
            return View.getSecondCoordinate();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getSecondCoordinates();
        }
    }
}