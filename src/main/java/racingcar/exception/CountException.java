package racingcar.exception;

abstract public class CountException {

    public static final String ERROR_MESSAGE = "숫자 1 이상 100 이하를 입력해 주세요.";

    public static void validation(String number) {
        numberValidation(number);
        numberRangeValidation(number);
    }

    private static void numberValidation(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    private static void numberRangeValidation(String number) {
        int count = Integer.parseInt(number);

        if (count <= 0 || count > 100) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }
}
