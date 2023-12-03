package codesquad.cardmatching.step1;

import codesquad.cardmatching.step1.domain.Card;
import codesquad.cardmatching.step1.domain.Coordinate;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class View {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String SPACE = " ";

    public static void printCardStatus(GameCardsDTO dto) {
        List<Card> firstRow = dto.getFirstRow();
        System.out.println(getRowStatus(firstRow));

        List<Card> secondRow = dto.getSecondRow();
        System.out.println(getRowStatus(secondRow));

        List<Card> thirdRow = dto.getThirdRow();
        System.out.println(getRowStatus(thirdRow));
    }

    private static String getRowStatus(List<Card> row) {
        return row.stream()
                .map(Card::getStatus)
                .collect(Collectors.joining(SPACE));
    }

    public static Coordinate getFirstCoordinate() {
        System.out.print("입력 1? ");
        String input = readLine();
        return Util.convertToCoordinate(input);
    }

    public static Coordinate getSecondCoordinate() {
        System.out.print("입력 2? ");
        String input = readLine();
        return Util.convertToCoordinate(input);
    }

    private static String readLine() {
        return scanner.nextLine();
    }
}