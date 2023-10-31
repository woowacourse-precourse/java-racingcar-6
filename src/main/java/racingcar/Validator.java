package racingcar;

public class Validator {
    public void validateNameLength(String s) {
        if (s.length() > 5) {
            throw new IllegalArgumentException(Message.NAME_LENGTH_ERROR.getMessage());
        }
    }
}
