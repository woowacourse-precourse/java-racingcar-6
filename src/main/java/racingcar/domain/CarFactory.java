package racingcar.domain;

import java.util.List;

public class CarFactory {

    public static Cars createCars(List<String> carNames) {
        return new Cars(carNames);
    }
}
