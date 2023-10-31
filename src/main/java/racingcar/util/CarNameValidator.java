package racingcar.util;

import java.util.Arrays;
import java.util.List;

public class CarNameValidator extends Validator {

    @Override
    public void validation(String input) {
        List<String> carNames = Arrays.stream(input.split(",")).toList();
        validationCarNamesLength(carNames);
        validationCarNamesListLength(carNames);
        validationDuplicate(carNames);
        validationCarNameHasSpace(carNames);

    }

    private void validationCarNamesLength(List<String> carNames) {
        carNames.stream().filter(name -> name.length() > 5 || name.isEmpty())
                .findAny()
                .ifPresent(name -> {
                    throw new IllegalArgumentException(ExceptionMessage.INVALID_CAR_NAME_LENGTH.getMessage());
                });
    }

    private void validationCarNamesListLength(List<String> carNames) {
        if (carNames.size() < 2) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NUMBER_OF_CARS.getMessage());
        }
    }

    private void validationDuplicate(List<String> carNames) {
        List<String> nonDuplicateList = carNames.stream().distinct().toList();
        if (carNames.size() != nonDuplicateList.size()) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_CAR_NAME_DUPLICATE.getMessage());
        }
    }

    private void validationCarNameHasSpace(List<String> carNames) throws IllegalArgumentException {
        carNames.stream().filter(name -> name.contains(" "))
                .findAny()
                .ifPresent(name -> {
                    throw new IllegalArgumentException(ExceptionMessage.INVALID_CAR_NAME_HAS_SPACE.getMessage());
                });
    }
}
