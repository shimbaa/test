package codesquad.cardmatching.step1;

import codesquad.cardmatching.step1.domain.Coordinate;
import java.util.Scanner;

public class View {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String SPACE = " ";
    private static final String GAME_INFO_MESSAGE_FORMAT = "<시도 %d, 남은 카드: %d> 좌표를 두 번 입력하세요.\n";
    private static final String FIRST_INPUT = "입력 1? ";
    private static final String SECOND_INPUT = "입력 2? ";

    public static void printCardStatus(GameCardsDTO dto) {
        dto.getCards().forEach((key, value) -> System.out.println(String.join(SPACE, value)));
        System.out.println();
    }

    public static void printGameInfoAndRequestMessage(int trialNumber, int countOfNotMatchedCards) {
        System.out.printf(GAME_INFO_MESSAGE_FORMAT, trialNumber, countOfNotMatchedCards);
    }

    public static Coordinate getFirstCoordinate() {
        System.out.print(FIRST_INPUT);
        String input = readLine();
        return Util.convertToCoordinate(input);
    }

    public static Coordinate getSecondCoordinate() {
        System.out.print(SECOND_INPUT);
        String input = readLine();
        return Util.convertToCoordinate(input);
    }

    //    모든 카드를 맞추거나 더 이상 남은 짝이 없을 경우 축하메시지를 출력하고 종료한다.
    public static void printGameFinishMessage() {
        System.out.println("축하합니다! 게임 종료");
    }

    public static void printErrorMessage(String message) {
        System.out.println(message);
    }

    private static String readLine() {
        return scanner.nextLine();
    }
}