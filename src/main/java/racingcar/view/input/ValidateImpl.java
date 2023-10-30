package racingcar.view.input;

public class ValidateImpl implements Validator {
    public void validateCarName(String carName) {
        if (carName.length() > NAME_LENGTH_LIMIT)
            throw new IllegalArgumentException(NAME_LENGTH_LIMIT_ERROR);
    }
}
