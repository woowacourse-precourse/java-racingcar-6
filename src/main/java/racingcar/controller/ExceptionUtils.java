package racingcar.controller;

import static racingcar.model.Car.MAX_LENGTH;

import racingcar.model.Car;
import racingcar.model.Racing;

public class ExceptionUtils {
    public ExceptionUtils() { }

    public boolean checkEmpty(String carName) { //빈 값의 경우
        if (carName.equals("")) {
            throw new IllegalArgumentException("입력된 자동차 이름이 없습니다.");
        }
        return true;
    }

    public boolean checkCountString(String count) {
        try {
            Integer.parseInt(count);
            return true;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public boolean checkLength(String carName) { //글자 체크
        if (carName.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 " + MAX_LENGTH + "글자 이하여야 합니다.");
        }
        return true;
    }

    public boolean checkExistComma(String carArray) {
        if(!carArray.contains(",")) {
            throw new IllegalArgumentException();
        }
        return true;
    }

}