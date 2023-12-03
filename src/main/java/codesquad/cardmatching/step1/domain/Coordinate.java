package codesquad.cardmatching.step1.domain;

public class Coordinate {
    private static final String ROW_OUT_OF_RANGE = "행의 값은 1에서 3사이여야 합니다.";
    private static final String COLUMN_OUT_OF_RANGE = "열의 값은 1에서 6사이여야 합니다.";
    private final int row;
    private final int column;

    public static Coordinate of(int row, int column) {
        return new Coordinate(row, column);
    }

    private Coordinate(int row, int column) {
        validate(row, column);
        this.row = row;
        this.column = column - 1;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    private void validate(int row, int column) {
        validateRow(row);
        validateColumn(column);
    }

    private void validateRow(int row) {
        if (row < 1 || row > 3) {
            throw new IllegalArgumentException(ROW_OUT_OF_RANGE);
        }
    }

    private void validateColumn(int column) {
        if (column < 1 || column > 6) {
            throw new IllegalArgumentException(COLUMN_OUT_OF_RANGE);
        }
    }
}