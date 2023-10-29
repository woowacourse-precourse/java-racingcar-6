package racingcar.constant;

public enum SymbolType {
    DELIMITER_SPLIT_CARS(","),
    DELIMITER_PRINT_CARS(", "),
    CAR_RESULT(" : "),
    TRACE_RACE_RESULT("-");

    private String symbol;

    SymbolType(String symbol) {
        this.symbol = symbol;
    }

    public String getValue() {
        return symbol;
    }
}
