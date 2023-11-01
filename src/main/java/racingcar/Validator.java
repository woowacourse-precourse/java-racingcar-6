package racingcar;

public class Validator {
    int NAME_LENGTH_LIMIT = 5;
    public void validateNameLength(String s) {
        if (s.length() > NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException(Message.NAME_LENGTH_ERROR.getMessage());
        }
    }
}
