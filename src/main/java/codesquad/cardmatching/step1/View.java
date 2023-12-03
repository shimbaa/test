package codesquad.cardmatching.step1;

import java.util.List;
import java.util.stream.Collectors;

public class View {

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
}