package racingcar.domain.validator;

import static racingcar.constant.MessageConstants.CAR_NAME_ALPHANUMERIC_COMMA_ONLY;
import static racingcar.constant.MessageConstants.CAR_NAME_DUPLICATE;
import static racingcar.constant.MessageConstants.CAR_NAME_MAX_LENGTH_EXCEEDED;
import static racingcar.constant.MessageConstants.CAR_NAME_NOT_PROVIDED;

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
        if (carNames.stream().anyMatch(name -> !name.matches("[a-zA-Z0-9,]+"))) {
            throw new IllegalArgumentException(CAR_NAME_ALPHANUMERIC_COMMA_ONLY);
        }
    }

    private void validateCarNameLength() {
        if (carNames.stream().anyMatch(name -> name.length() > 5)) {
            throw new IllegalArgumentException(CAR_NAME_MAX_LENGTH_EXCEEDED);
        }
    }

    private void validateCarNameDuplicate() {
        if (carNames.size() != carNames.stream().distinct().count()) {
            throw new IllegalArgumentException(CAR_NAME_DUPLICATE);
        }
    }

}
