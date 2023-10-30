package racingcar;

public class Validator {
    public static void validateCar(String[] cars) {
        for (String car : cars) {
            if (car.length() > 5) {
                throw new IllegalArgumentException("자동차 이름이 5자를 넘습니다.");
            }
        }
    }
}
