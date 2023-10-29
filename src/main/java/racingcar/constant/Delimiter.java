package racingcar.constant;

public enum Delimiter {
    COMMA(","),
    COMMA_WITH_SPACE(", ");
    private final String symbol;

    Delimiter(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
