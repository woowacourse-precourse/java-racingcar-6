package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {
    public List<RacingCar> racingCars;

    RacingCars() {
        racingCars = new ArrayList<>();
    }

    public void add(RacingCar racingCar) {
        racingCars.add(racingCar);
    }

    public int size() {
        return racingCars.size();
    }

    public RacingCar get(int index) {
        return racingCars.get(index);
    }

    public int farthestDistance() {
        int farthest = 0;
        for (RacingCar racingCar : racingCars) {
            farthest = Math.max(farthest, racingCar.getDistance());
        }
        return farthest;
    }
}