package racingcar.util.model;

public abstract class Reader {

    protected void validateBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException();
        }
    }
    public abstract String read();
}
