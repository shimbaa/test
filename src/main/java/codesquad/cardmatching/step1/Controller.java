package codesquad.cardmatching.step1;

public class Controller {

    private final GameService gameService = new GameService();

    public void run() {
        gameService.initGameCards();
        GameCardsDTO gameCardDTO = gameService.getGameCardDTO();
        printInitialCardStatus(gameCardDTO);
    }

    private void printInitialCardStatus(GameCardsDTO gameCardDTO) {
        View.printCardStatus(gameCardDTO);
    }
}