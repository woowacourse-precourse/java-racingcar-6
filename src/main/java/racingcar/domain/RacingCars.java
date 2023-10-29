package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {
    public List<RacingCar> racingcars;

    public RacingCars() {

        racingcars = new ArrayList<>();
    }


    public void add(RacingCar racingcar) {

        racingcars.add(racingcar);
    }

    public int size() {
        return racingcars.size();
    }

    public RacingCar get(int index) {

        return racingcars.get(index);
    }

    public int farthestDistance() {
        int farthest = 0;
        for (RacingCar racingcar : racingcars) {
            farthest = Math.max(farthest, racingcar.getDistance());
        }
        return farthest;
    }


}