package codesquad.cardmatching.step1;

import codesquad.cardmatching.step1.domain.Coordinate;

public class Controller {

    private final GameService gameService = new GameService();

    public void run() {
        gameService.initGameCards(GameCardGenerator.newGameCards());
        GameCardsDTO gameCardDTO = gameService.getGameCardDTO();
        printInitialCardStatus(gameCardDTO);

        do {
            Coordinate firstCoordinates = getFirstCoordinates();
            Coordinate secondCoordinates = getSecondCoordinates();

            GameCardsDTO queriedStatus = gameService.getQueriedStatus(firstCoordinates, secondCoordinates);
            View.printCardStatus(queriedStatus);

            gameService.compareQueriedCards(firstCoordinates, secondCoordinates);
            GameCardsDTO comparedResult = gameService.getGameCardDTO();
            View.printCardStatus(comparedResult);
        } while (gameService.isMatchingCardsExist());
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