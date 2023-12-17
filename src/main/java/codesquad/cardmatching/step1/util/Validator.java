package codesquad.cardmatching.step1.util;


import org.assertj.core.util.Strings;

public class Validator {

    private static final String NULL_OR_EMPTY = "빈칸이나 공백이 아닌 값을 입력해주세요";
    private static final String NOT_INTEGER = "숫자만 입력해주세요";
    private static final String COMMA = ",";
    private static final int VALID_COORDINATE_INPUT_LIST_SIZE = 2;
    private static final String INVALID_INPUT_FORMAT = "올바른 입력값이 아닙니다.";

    public static void validateIsNullOrEmpty(String value) {
        if (Strings.isNullOrEmpty(value.trim())) {
            throw new IllegalArgumentException(NULL_OR_EMPTY);
        }
    }

    public static void validateIsInteger(String value) {
        if (!isInteger(value)) {
            throw new IllegalArgumentException(NOT_INTEGER);
        }
    }

    private static boolean isInteger(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException exception) {
            return false;
        }
    }

    public static void validateContainsComma(String value) {
        if (!value.contains(COMMA)) {
            throw new IllegalArgumentException(INVALID_INPUT_FORMAT);
        }
    }

    public static void validateCoordinateInputListSize(int size) {
        if (size != VALID_COORDINATE_INPUT_LIST_SIZE) {
            throw new IllegalArgumentException(INVALID_INPUT_FORMAT);
        }
    }

    private Validator() {
    }
}