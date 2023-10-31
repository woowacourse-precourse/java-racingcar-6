package racingcar.controller;

import java.util.List;

public class Exception {
    public void CarNameException(List<String> carNames) {
        for (String car : carNames) {
            if (car.length() > 5) {
                throw new IllegalArgumentException("Invalid argument: 이름은 5자 이하여야 합니다.");
            }
        }
    }
}
