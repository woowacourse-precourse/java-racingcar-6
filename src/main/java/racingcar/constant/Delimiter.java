package racingcar.constant;

public enum Delimiter {

    COMMA(","),
    WINNER_OUTPUT_DELIMITER(", ");


    private final String delimiter;


    Delimiter(String delimiter) {
        this.delimiter = delimiter;
    }


    public String getDelimiter() {
        return delimiter;
    }
}
