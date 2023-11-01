package racingcar.enums;

public enum Symbols {
    GAME_SCORE("-"),
    COMMA(",");

    private final String symbol;

    Symbols(final String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
