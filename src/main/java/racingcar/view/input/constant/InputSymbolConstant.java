package racingcar.view.input.constant;

public enum InputSymbolConstant {
    CAR_NAME_DELIMITER(","),
    BLANK(" "),
    VOID("");
    private final String symbol;

    InputSymbolConstant(final String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}