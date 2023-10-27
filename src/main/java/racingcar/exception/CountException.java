package racingcar.exception;

abstract public class CountException {

    public static void validation(String number) {
        numberValidation(number);
        numberRangeValidation(number);
    }

    private static void numberValidation(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }

    private static void numberRangeValidation(String number) {
        int count = Integer.parseInt(number);

        if (count <= 0 || count > 100) {
            throw new IllegalArgumentException("숫자는 1 이상 100 이하를 입력해 주세요.");
        }
    }
}
