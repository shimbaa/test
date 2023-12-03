package codesquad.cardmatching.step1;

import codesquad.cardmatching.step1.domain.Coordinate;

public class Controller {

    private final GameService gameService = new GameService();

    public void run() {
        gameService.initGameCards();
        GameCardsDTO gameCardDTO = gameService.getGameCardDTO();
        printInitialCardStatus(gameCardDTO);

        Coordinate firstCoordinates = getFirstCoordinates();
        Coordinate secondCoordinates = getSecondCoordinates();
        GameCardsDTO queriedStatus = gameService.getQueriedStatus(firstCoordinates, secondCoordinates);
        View.printCardStatus(queriedStatus);
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