package racingcar;

public class Validation {

    private static final int CAR_NAME_LENGTH = 5;
    private static final String CAR_COUNT_ERROR = "2개 이상의 자동차를 입력해주세요.";
    private static final String CAR_NAME_ERROR = "자동차 이름의 길이는 4를 초과할 수 없습니다.";
    private static final String NUMBER_ERROR = "1이상의 숫자를 입력해주세요.";

    public static String[] throwIfCarInputIsInvalid(String input) {
        String[] cars = input.split(",");
        if(cars.length < 2) {
            throw new IllegalArgumentException(CAR_COUNT_ERROR);
        }
        for (String car : cars) {
            if (car.length() > CAR_NAME_LENGTH) {
                throw new IllegalArgumentException(CAR_NAME_ERROR);
            }
        }
        return cars;
    }

    public static int throwIfCountInputIsInvalid(String count) {
        int number;
        try {
            number = Integer.parseInt(count);
        } catch (Exception e) {
            throw new IllegalArgumentException(NUMBER_ERROR);
        }
        if(number <= 0) {
            throw new IllegalArgumentException(NUMBER_ERROR);
        }
        return number;
    }
}
