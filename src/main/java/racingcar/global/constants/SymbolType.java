package racingcar.global.constants;

public enum SymbolType {
    DELIMITER(",");

    private final String symbol;

    SymbolType(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return this.symbol;
    }
}
