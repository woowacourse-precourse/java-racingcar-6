package racingcar.enums;

public enum Symbol {
    CAR_NAME_DELIMITER(","),
    KEY_VALUE_SEPARATOR(" : "),
    WINNER_DELIMITER(", "),
    POSITION_MARKER("-");

    private final String symbol;

    Symbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
