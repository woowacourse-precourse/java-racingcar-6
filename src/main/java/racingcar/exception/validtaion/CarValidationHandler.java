package racingcar.exception.validtaion;

public class CarValidationHandler {
    private static final String ALPHA_NUMERIC_REGEX = "^[a-zA-Z0-9]*$";
    private static final String ALPHA_REGEX = "^[a-zA-Z]*$";
    private static final String NUMERIC_REGEX = "^[0-9]*$";
    public static final String CAR_NAME_LENGTH_RESTRICTION = "자동차 이름은 5글자 이하로 입력해주세요.";
    public static final String CAR_NAME_FORMAT_RESTRICTION = "자동차 이름은 영어, 숫자의 조합 또는 영어와 숫자로만 입력해주세요.";

    private CarValidationHandler() {
    }

    public static void validationAlphaNumericOrAlphaOrNumeric(String carName) {
        if (!isAlphaNumericOrAlphaOrNumeric(carName)) {
            throw new IllegalArgumentException(CAR_NAME_FORMAT_RESTRICTION);
        }
    }

    public static void validationCarNameUnder5Length(String carName) {
        if (!isCarNameUnder5Length(carName)) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_RESTRICTION);
        }
    }

    private static boolean isCarNameUnder5Length(String carName) {
        return carName.length() <= 5;
    }

    private static boolean isAlphaNumericOrAlphaOrNumeric(String carName) {
        return isAlphaNumeric(carName) || isNumeric(carName) || isAlpha(carName);
    }

    private static boolean isAlphaNumeric(String carName) {
        return carName.matches(ALPHA_NUMERIC_REGEX);
    }

    private static boolean isAlpha(String carName) {
        return carName.matches(ALPHA_REGEX);
    }

    private static boolean isNumeric(String carName) {
        return carName.matches(NUMERIC_REGEX);
    }
}
