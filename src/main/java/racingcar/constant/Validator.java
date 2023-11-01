package racingcar.constant;

import java.util.function.Consumer;

public enum Validator {
    NUMBER(input -> {
        if (!input.matches("^[0-9]+$")) {
            throw new IllegalArgumentException(ExceptionType.NUMBER.message());
        }
    }),
    NAME(input -> {
        if (!input.matches("^\\S{1,5}$")) {
            throw new IllegalArgumentException(ExceptionType.NAME.message());
        }
    });

    private final Consumer<String> expression;

    Validator(Consumer<String> expression) {
        this.expression = expression;
    }

    public void validate(String input) {
        expression.accept(input);
    }
}
