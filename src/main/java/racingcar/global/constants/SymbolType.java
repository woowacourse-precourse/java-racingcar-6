package racingcar.global.constants;

public enum SymbolType {
    DELIMITER(","),
    RESULT_POSITION("-"),
    RESULT_TOKEN(" : "),
    FINAL_RESULT_TOKEN(", ");

    private final String symbol;

    SymbolType(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return this.symbol;
    }
}
