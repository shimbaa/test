package codesquad.cardmatching.step1;

public enum CardStatus {
    MATCHED(" "),
    NOT_MATCHED("X");

    private final String label;

    CardStatus(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return this.label;
    }
}