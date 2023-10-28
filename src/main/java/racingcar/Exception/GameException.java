package racingcar.Exception;

public class GameException extends RuntimeException {

    public static class CarNameException extends RuntimeException {
        public CarNameException(String message) {
            super(message);
        }
    }

    public static class RoundException extends RuntimeException {
        public RoundException(String message) {
            super(message);
        }
    }
}