package racingcar.model;

public class MovingNumber {
    private static String NOT_INTEGER_ERROR_MESSAGE = "정수가 아닌 값을 입력했습니다.";
    private static String NOT_POSITIVE_INTEGER_ERROR_MESSAGE = "양의 정수가 아닌 값을 입력했습니다.";

    private int movingNumber;

    private MovingNumber(final int number) {
        validateMovingNumber(number);
        this.movingNumber = number;
    }

    public static MovingNumber createMovingNumber(final String number) {
        return new MovingNumber(convertToInteger(number));
    }

    private static int convertToInteger(final String number) {
        try {
            return Integer.parseInt(number);
        } catch (Exception e) {
            throw new IllegalArgumentException(NOT_INTEGER_ERROR_MESSAGE);
        }
    }

    private static void validateMovingNumber(final int number) {
        if (number <= 0) {
            throw new IllegalArgumentException(NOT_POSITIVE_INTEGER_ERROR_MESSAGE);
        }
    }

    public int getNumber() {
        return this.movingNumber;
    }
}
