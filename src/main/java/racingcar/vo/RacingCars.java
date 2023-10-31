package racingcar.vo;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {
    private List<RacingCar> racingCars = new ArrayList<>();

    public RacingCars(List<String> cars) {
        for (String car : cars) {
            racingCars.add(new RacingCar(car));
        }
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }
}
