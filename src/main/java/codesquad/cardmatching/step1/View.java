package codesquad.cardmatching.step1;

import codesquad.cardmatching.step1.domain.Coordinate;
import java.util.Scanner;

public class View {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String SPACE = " ";
    private static final String FIRST_INPUT = "입력 1? ";
    private static final String SECOND_INPUT = "입력 2? ";

    public static void printCardStatus(GameCardsDTO dto) {
        dto.getCards().forEach((key, value) -> System.out.println(String.join(SPACE, value)));
        System.out.println();
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

    private static String readLine() {
        return scanner.nextLine();
    }
}