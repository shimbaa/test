package codesquad.cardmatching.step1.util;

import codesquad.cardmatching.step1.domain.Coordinate;
import java.util.Arrays;
import java.util.List;

public class Util {
    private static final String OPENING_SMALL_BRACKET = "(";
    private static final String CLOSING_SMALL_BRACKET = ")";
    private static final String REPLACEMENT = "";
    private static final String COMMA = ",";
    private static final int FIRST_INDEX = 0;
    private static final int SECOND_INDEX = 1;

    public static Coordinate convertToCoordinate(String input) {
        Validator.validateIsNullOrEmpty(input);

        String withoutBrackets = removeAllSmallBrackets(input);
        Validator.validateContainsComma(withoutBrackets);

        List<String> coordinatesList = splitByCommaConvertToList(withoutBrackets);
        Validator.validateCoordinateInputListSize(coordinatesList.size());

        String xCoordinateStr = coordinatesList.get(FIRST_INDEX).trim();
        String yCoordinateStr = coordinatesList.get(SECOND_INDEX).trim();

        validateIsInteger(xCoordinateStr, yCoordinateStr);
        return Coordinate.of(Integer.parseInt(xCoordinateStr), Integer.parseInt(yCoordinateStr));
    }

    private static void validateIsInteger(String xCoordinateStr, String yCoordinateStr) {
        Validator.validateIsInteger(xCoordinateStr);
        Validator.validateIsInteger(yCoordinateStr);
    }

    private static String removeAllSmallBrackets(String input) {
        return input.replace(OPENING_SMALL_BRACKET, REPLACEMENT)
                .replace(CLOSING_SMALL_BRACKET, REPLACEMENT);
    }

    private static List<String> splitByCommaConvertToList(String str) {
        return Arrays.asList(str.split(COMMA));
    }
}