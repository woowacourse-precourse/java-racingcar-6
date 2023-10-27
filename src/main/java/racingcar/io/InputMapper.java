package racingcar.io;

import racingcar.model.Cars;

public class InputMapper {

    public Cars toCars(String carNames) {
        return new Cars(carNames);
    }
}
