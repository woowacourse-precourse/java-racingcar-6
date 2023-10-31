package racingcar.validate;

public class ValidateNumber {

    private static final String COUNT_ERROR_MESSAGE = "위치가 0 미만이면 출력할 수 없습니다.";

    public static void validateForwardCount(Long forwardCount) {
        if (forwardCount < 0) {
            throw new IllegalArgumentException(COUNT_ERROR_MESSAGE);
        }
    }
}
