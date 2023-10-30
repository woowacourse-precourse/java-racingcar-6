package racingcar.constant;

public enum Delimiter {
    COMMA(","),
    BLANK(" "),
    DOUBLE_COMMA(COMMA.expression + COMMA.expression),
    BLANK_AFTER_COMMA(COMMA.expression + BLANK.expression),
    BLANK_BEFORE_COMMA(BLANK.expression + COMMA.expression);

    private final String expression;

    Delimiter(final String expression) {
        this.expression = expression;
    }

    public String toExpression() {
        return this.expression;
    }
}
