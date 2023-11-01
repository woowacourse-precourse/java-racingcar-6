package racingcar.controller;

import java.util.List;

public class Exception {
    public static final int CAR_NAME_CONDITIONS = 5;
    public static final String CAR_NAME_EXCEPTION = "Invalid argument: 이름은 5자 이하여야 합니다.";

    public void CarNameException(List<String> carNames) {
        for (String car : carNames) {
            if (car.length() > CAR_NAME_CONDITIONS) {
                throw new IllegalArgumentException(CAR_NAME_EXCEPTION);
            }
        }
    }
}
