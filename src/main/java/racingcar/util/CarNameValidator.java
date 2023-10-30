package racingcar.util;

public class CarNameValidator {

    private final static String CAR_NAME_LENGTH_ERROR = "자동차의 이름은 5글자 이하로 입력해야 합니다.";
    private final static int MAX_CAR_NAME_LENGTH = 5;

    public static String[] validateCarNames(String input) {
        String[] carNames = splitCarNames(input);
        isLengthValid(carNames);
        return carNames;
    }

    private static String[] splitCarNames(String input) {
        return input.split(",");
    }

    private static void isLengthValid(String[] carNames) {

        for (String carName : carNames) {
            if (carName.length() >= MAX_CAR_NAME_LENGTH) {
                throw new IllegalArgumentException(CAR_NAME_LENGTH_ERROR);
            }
        }
    }
}
