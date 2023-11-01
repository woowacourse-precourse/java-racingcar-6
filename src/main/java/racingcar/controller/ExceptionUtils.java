package racingcar.controller;

import static racingcar.model.Car.MAX_LENGTH;
public class ExceptionUtils {
    private ExceptionUtils() { }

    private static void checkEmpty(String carName) { //빈 값의 경우
        if (carName.equals("")) {
            throw new IllegalArgumentException("입력된 자동차 이름이 없습니다.");
        }
    }

    private static void checkLength(String carName) { //글자 체크
        if (carName.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 " + MAX_LENGTH + "글자 이하여야 합니다.");
        }
    }

    private static void checkExistCar(String carArray) { //중복 이름 금지
        if(!carArray.contains(",")) {
            throw new IllegalArgumentException("중복된 자동차 이름이 존재합니다.");
        }
    }

    public static void checkAllName(String carName) {
        checkEmpty(carName);
        checkLength(carName);
        checkExistCar(carName);
    }

}