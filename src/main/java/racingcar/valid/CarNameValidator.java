package racingcar.valid;

import java.util.List;

public class CarNameValidator {
    private static final int MAX_CAR_NAME_LENGTH = 5;

    public static void validate(List<String> carNames) {
        carNames.forEach(CarNameValidator::carNameLengthValidate);
        duplicateValidate(carNames);
    }

    private static void duplicateValidate(List<String> carNames) {
        if (carNames.stream().distinct().count() != carNames.size()) {
            throw new IllegalArgumentException("중복된 이름이 존재합니다.");
        }
    }

    private static void carNameLengthValidate(String carName) {
        if (carName.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }
}
