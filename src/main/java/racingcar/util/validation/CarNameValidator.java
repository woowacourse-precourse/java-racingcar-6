package racingcar.util.validation;

public class CarNameValidator {

    private static final Integer CAR_NAME_MAX_LENGTH = 5;
    private static final String INVALID_CAR_NAME_LENGTH_ERROR_MESSAGE = "자동차 이름은 %s자 이하만 가능합니다.";

    private CarNameValidator() {
    }

    public static void validateCarName(String carName) {
        if (isCarNameLongerThanMaxLength(carName)) {
            String errorMessage = String.format(INVALID_CAR_NAME_LENGTH_ERROR_MESSAGE, CAR_NAME_MAX_LENGTH);
            throw new IllegalArgumentException(errorMessage);
        }
    }

    private static boolean isCarNameLongerThanMaxLength(String carName) {
        return carName.length() > CAR_NAME_MAX_LENGTH;
    }
}
