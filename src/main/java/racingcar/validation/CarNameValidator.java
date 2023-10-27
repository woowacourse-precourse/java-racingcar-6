package racingcar.validation;

import racingcar.message.ErrorMessage;
import racingcar.resource.CarGameValue;

import java.util.Arrays;
import java.util.List;

public class CarNameValidator {

    private final String CAR_NAME_STRINGS;
    private final List<String> CAR_NAMES;

    public CarNameValidator(String carNameStrings) {
        this.CAR_NAME_STRINGS = carNameStrings;
        this.CAR_NAMES = Arrays.asList(carNameStrings.split(","));
        validate();
    }
    public void validate() {
        validateNull();
        validateBlank();
    }

    public void validateNull() {
        CAR_NAMES.forEach(StringValidator::stringIsNull);
    }

    public void validateBlank() {
        CAR_NAMES.forEach(StringValidator::stringIsBlank);
    }
}
