package racingcar.constant;

public enum Delimeter {

    COMMA(","),
    WINNER_OUTPUT_DELIMETER(", ");


    private String delimeter;


    Delimeter(String delimeter) {
        this.delimeter = delimeter;
    }


    public String getDelimeter() {
        return delimeter;
    }
}
