package racingcar.exception;

public class GameException {
    public void checkNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }
}
