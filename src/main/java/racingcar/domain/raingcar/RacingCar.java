package racingcar.domain.raingcar;

import java.util.regex.Pattern;
import racingcar.constant.ErrorMessage;

public class RacingCar {

    public static final Integer CAR_NAME_MIN_SIZE = 1;
    public static final Integer CAR_NAME_MAX_SIZE = 5;
    public static final String CAR_NAME_REGEX_EXPRESSION = "[^A-Za-z]+";
    private String name;
    private Integer position;

    public RacingCar(String name) {
        verify(name);

        this.name = name;
        this.position = 0;
    }

    public RacingCar(String name, Integer position) {
        verify(name);

        this.name = name;
        this.position = position;
    }

    public void moveForward() {
        this.position++;
    }

    public String getName() {
        return this.name;
    }

    public Integer getPosition() {
        return this.position;
    }

    private void verify(String name) {
        validateMinimumSize(name);
        validateMaximumSize(name);
        validateInvalidInput(name);
    }

    private void validateInvalidInput(String name) {
        Pattern pattern = Pattern.compile(CAR_NAME_REGEX_EXPRESSION);
        if (pattern.matcher(name).find()) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_INVALID_CHARACTER_ERROR);
        }
    }

    private void validateMaximumSize(String name) {
        if (name.length() > CAR_NAME_MAX_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_LENGTH_ERROR);
        }
    }

    private void validateMinimumSize(String name) {
        if (name.length() < CAR_NAME_MIN_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_LENGTH_ERROR);
        }
    }
}