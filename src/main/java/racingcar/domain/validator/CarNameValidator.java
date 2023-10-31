package racingcar.domain.validator;

import static racingcar.constant.MessageConstants.CAR_NAME_ALPHANUMERIC_COMMA_ONLY;
import static racingcar.constant.MessageConstants.CAR_NAME_DUPLICATE;
import static racingcar.constant.MessageConstants.CAR_NAME_MAX_LENGTH_EXCEEDED;
import static racingcar.constant.MessageConstants.CAR_NAME_NOT_PROVIDED;
import static racingcar.constant.MessageConstants.CAR_NAME_REGEX;
import static racingcar.constant.NumberConstants.MAX_CAR_NAME_LENGTH;

import java.util.List;

public class CarNameValidator {

    private final List<String> carNames;

    public CarNameValidator(List<String> carNames) {
        this.carNames = carNames;
    }

    public void validateAll() {
        validateCarNameExists();
        validateAlphanumericAndCommaCarName();
        validateCarNameLength();
        validateCarNameDuplicate();
    }

    private void validateCarNameExists() {
        if (carNames.stream().anyMatch(String::isBlank)) {
            throw new IllegalArgumentException(CAR_NAME_NOT_PROVIDED);
        }
    }

    private void validateAlphanumericAndCommaCarName() {
        if (carNames.stream().anyMatch(name -> !isValidCarName(name))) {
            throw new IllegalArgumentException(CAR_NAME_ALPHANUMERIC_COMMA_ONLY);
        }
    }

    private boolean isValidCarName(String name) {
        return name.matches(CAR_NAME_REGEX);
    }

    private void validateCarNameLength() {
        if (carNames.stream().anyMatch(name -> name.length() > MAX_CAR_NAME_LENGTH)) {
            throw new IllegalArgumentException(CAR_NAME_MAX_LENGTH_EXCEEDED);
        }
    }

    private void validateCarNameDuplicate() {
        if (carNames.size() != carNames.stream().distinct().count()) {
            throw new IllegalArgumentException(CAR_NAME_DUPLICATE);
        }
    }

}
