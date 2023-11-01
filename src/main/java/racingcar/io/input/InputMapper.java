package racingcar.io.input;

import racingcar.model.Cars;

public class InputMapper {

    public Cars toCars(String carNames) {
        return new Cars(carNames);
    }

    public int toInt(String attemptCount) {
        return Integer.parseInt(attemptCount);
    }
}
