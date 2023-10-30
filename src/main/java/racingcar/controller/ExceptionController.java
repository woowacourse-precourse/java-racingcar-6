package racingcar.controller;

public class ExceptionController {

    public static void carNameMaxLengthException(String[] carNameArr) {
        for (String userCar : carNameArr) {
            if (userCar.length() > 5) {
                throw new IllegalArgumentException("자동차의 이름은 5글자를 초과할 수 없습니다.");
            }
        }
    }

}
