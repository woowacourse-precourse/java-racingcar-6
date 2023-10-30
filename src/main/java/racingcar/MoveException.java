package racingcar;

public class MoveException {
    MoveException(){}

    public boolean isValidLength(String move) {
        return move.length() == 1;
    }

    public boolean isDigit(String move) {
        return (move.charAt(0) >= '0' && move.charAt(0) <= '9');
    }

    public void moveException(String move) throws IllegalArgumentException {
        if (!isValidLength(move)) throw new IllegalArgumentException();
        if (!isDigit(move)) throw new IllegalArgumentException();
    }
}
