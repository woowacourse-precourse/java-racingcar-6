package racingcar.domain;

import java.util.List;

public class ErrorCheck {

    public void carNameCheck(List<String> cars) {
        for (String car : cars) {
            biggerThanFive(car);
        }
    }

    public void biggerThanFive(String car) {
        if (car.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }




}
