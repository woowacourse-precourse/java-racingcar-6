package racingcar.util;

public class CarNameValidator {
    private final static int MAX_CARNAME = 5;

    public static String validateCarName(String carName) {
        if (carName.length() > MAX_CARNAME) {
            throw new IllegalArgumentException("자동차 이름이 5글자 이하이어야 합니다");
        } else return carName;
    }
}
