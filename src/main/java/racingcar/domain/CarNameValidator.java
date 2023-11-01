package racingcar.domain;

import static racingcar.utils.Constants.NAME_SIZE_MESSAGE;
import static racingcar.utils.Constants.RIGHT_NAME_MESSAGE;
import static racingcar.utils.Constants.SAME_NAME_MESSAGE;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import racingcar.utils.Constants;

public class CarNameValidator {
    private String carNames;
    private List<String> names;

    public CarNameValidator(String carNames) {
        this.carNames = carNames;
        this.names = Arrays.asList(carNames.split(","));
        validate();
    }

    private void validate() {
        isRightInput();
        isRightSize();
        isSameName();
    }

    public void isRightSize() {
        if (names.stream().anyMatch(name -> name.isEmpty() || name.length() > Constants.NAME_SIZE)) {
            throw new IllegalArgumentException(NAME_SIZE_MESSAGE);
        }
    }

    public void isRightInput() {
        Matcher matcher = Constants.NAME_STRING_PATTERN.matcher(carNames);
        if (!matcher.find()) {
            throw new IllegalArgumentException(RIGHT_NAME_MESSAGE);
        }
    }

    public void isSameName() {
        if (names.stream().distinct().count() < names.size()) {
            throw new IllegalArgumentException(SAME_NAME_MESSAGE);
        }
    }


}
