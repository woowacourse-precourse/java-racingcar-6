package racingcar.validation;

public class TryCountValidator {

    public static int validateTryCount(String input) {
        int tryCount = parseInputToInteger(input);
        return tryCount;
    }

    private static int parseInputToInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 다른 문자를 입력하였습니다. 숫자를 입력해주세요.");
        }
    }

}
