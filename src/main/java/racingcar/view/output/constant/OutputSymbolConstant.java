package racingcar.view.output.constant;

public enum OutputSymbolConstant {
    NEW_LINE(System.lineSeparator()),
    CAR_DISTANCE_VALUE_SYMBOL("-"),
    FINAL_WINNER_DUPLICATE_DELIMITER(", ");
    private final String symbol;

    OutputSymbolConstant(final String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}