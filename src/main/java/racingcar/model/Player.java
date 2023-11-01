package racingcar.model;

import java.util.List;

public class Player {
    private List<String> carName;
    private int attemptNumber;

    public List<String> getCarName() {
        return carName;
    }

    public void setCarName(String carNames) {
        carName = CarNameValidator.validateCarName(carNames);
    }

    public int getAttemptNumber() {
        return attemptNumber;
    }

    public void setAttemptNumber(String number) {
        attemptNumber = AttemptNumValidator.validateNumber(number);
    }
}