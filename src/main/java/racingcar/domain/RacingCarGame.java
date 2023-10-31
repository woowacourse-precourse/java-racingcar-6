package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {
    public List<RacingCar> createRacingCars(List<String> carNames) {
        List<RacingCar> racingCars = new ArrayList<>();

        for (int i = 0; i < carNames.size(); i++) {
            racingCars.add(new RacingCar(carNames.get(i)));
        }

        return racingCars;
    }
}
