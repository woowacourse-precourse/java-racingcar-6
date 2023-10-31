package racingcar.model;

import java.util.List;

public class Name {

    private static final int MAX_CAR_NAME_LENGTH = 5;

    public void isValid(List<String> carNames) {
        for (String carName : carNames) {
            if (carName.length() > MAX_CAR_NAME_LENGTH) {
                throw new IllegalArgumentException();
            }
        }
    }
}