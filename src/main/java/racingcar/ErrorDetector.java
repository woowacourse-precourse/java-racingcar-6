package racingcar;

public class ErrorDetector {

    private static final int NAME_LENGTH_LIMIT = 5;
    private static final String NAME_ERROR_MESSAGE = "자동차 이름의 길이는 4를 초과할 수 없습니다.";
    private static final String NUMBER_ERROR_MESSAGE = "숫자를 입력해주세요.";

    public static String[] throwIfCarNameIsLong(String input) {
        String[] cars = input.split(",");
        for (String car : cars) {
            if (car.length() > NAME_LENGTH_LIMIT) {
                throw new IllegalArgumentException(NAME_ERROR_MESSAGE);
            }
        }
        return cars;
    }

    public static int throwIfInputIsString(String count) {
        try {
           return Integer.parseInt(count);
        } catch (Exception e) {
            throw new IllegalArgumentException(NUMBER_ERROR_MESSAGE);
        }
    }
}
