package racingcar.Exception;

public class GameException extends RuntimeException {

    public static class CarNameException extends IllegalArgumentException {
        public CarNameException(String message) {
            super(message);
        }
    }

    public static class RoundException extends IllegalArgumentException {
        public RoundException(String message) {
            super(message);
        }
    }
}