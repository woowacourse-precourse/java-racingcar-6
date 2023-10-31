package racingcar.validation;

import racingcar.message.ErrorMessage;
import racingcar.resource.CarGameValue;

import java.util.Arrays;
import java.util.List;

public class CarNameValidator {

    private final List<String> CAR_NAMES;

    public CarNameValidator(String carNameStrings) {
        this.CAR_NAMES = Arrays.asList(carNameStrings.split(","));
    }

    public List<String> validate() {
        validateNull();
        validateBlank();
        validateLength();
        validateDuplicate();
        return this.CAR_NAMES;
    }

    public void validateNull() {
        this.CAR_NAMES.forEach(StringValidator::stringIsNull);
    }

    public void validateBlank() {
        this.CAR_NAMES.forEach(StringValidator::stringIsBlank);
    }

    public void validateLength() {
        if (this.CAR_NAMES.stream().anyMatch(name -> name.length() > CarGameValue.CAR_NAME_MAX_LENGTH.getValue())) {
            throw new IllegalArgumentException(String.format(ErrorMessage.INPUT_NAME_LENGTH_MESSAGE.getValue(), 5));
        }
    }

    public void validateDuplicate() {
        if (this.CAR_NAMES.size() != this.CAR_NAMES.stream().distinct().count()) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_NAME_DUPLICATE_MESSAGE.getValue());
        }
    }
}
