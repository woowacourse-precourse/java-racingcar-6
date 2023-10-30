package racingcar.domain;

import java.util.List;

public class RacingCars {

    private List<RacingCar> racingCars;

    public RacingCars(List<String> carNames) {
        carNames.forEach(carName -> racingCars.add(new RacingCar(carName)));
    }

}
