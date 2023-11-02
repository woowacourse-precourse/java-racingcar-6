package racingcar.domain.exception;

public class BadRaceRoundException extends IllegalArgumentException {
    public BadRaceRoundException() {
        super();
    }

    public BadRaceRoundException(String s) {
        super(s);
    }
}
