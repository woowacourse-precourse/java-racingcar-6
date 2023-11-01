package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {
    private final List<RacingCar> racingCarList;

    public RacingCars() {
        this.racingCarList = new ArrayList<>();
    }

    public void addRacingCar(String name) {
        RacingCar car = new RacingCar(name);
        racingCarList.add(car);
    }

    public List<RacingCar> getRacingCars() {
        return racingCarList;
    }

}
