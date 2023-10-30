package racingcar.util;

public class validation {

    private static final Integer MAX_LENGTH = 5;
    public static void maxLength(String cars) throws IllegalArgumentException {
        if (cars.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("5자 이상의 자동차 명은 입력 불가");
        }
    }
}
