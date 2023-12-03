package codesquad.cardmatching.step1;

public enum Row {
    FIRST(1),
    SECOND(2),
    THIRD(3);

    private final Integer value;

    Row(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
