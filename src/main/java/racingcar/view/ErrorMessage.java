package racingcar.view;

public final class ErrorMessage {
    private static final String IS_NOT_NULL_ERROR_MESSAGE = "입력한 문자열에 올바르지 못한 값이 포함되어 있습니다.";
    private static final String SEPERATOR_ERROR_MESSAGE = "구분자는 콤마 1개로만 이루어져야 합니다.";
    private static final String CAR_NUMBER_ERROR_MESSAGE = "1대 이상의 자동차를 입력해야 합니다.";
    private static final String CAR_NAME_LENGTH_ERROR_MESSAGE = "자동차의 이름은 5자 이하여야 합니다.";
    private static final String CAR_NAMES_NOT_DUPLICATE_ERROR_MESSAGE = "자동차의 이름은 중복될 수 없습니다.";
    private static final String IS_DIGIT_ERROR_MESSAGE = "시도 횟수는 숫자로만 입력해야 합니다.";
    private static final String TRY_NUMBER_ERROR_MESSAGE = "시도 횟수는 0 이상이어야 합니다.";

    public static void isNotNullError() {
        System.out.println(IS_NOT_NULL_ERROR_MESSAGE);
    }

    public static void separatorError() {
        System.out.println(SEPERATOR_ERROR_MESSAGE);
    }

    public static void carNumberError() {
        System.out.println(CAR_NUMBER_ERROR_MESSAGE);
    }

    public static void carNameLengthError() {
        System.out.println(CAR_NAME_LENGTH_ERROR_MESSAGE);
    }

    public static void carNamesNotDuplicateError() {
        System.out.println(CAR_NAMES_NOT_DUPLICATE_ERROR_MESSAGE);
    }

    public static void isDigitError() {
        System.out.println(IS_DIGIT_ERROR_MESSAGE);
    }

    public static void tryNumberError() {
        System.out.println(TRY_NUMBER_ERROR_MESSAGE);
    }
}
