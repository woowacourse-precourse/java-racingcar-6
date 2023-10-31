package racingcar.model;

import java.util.List;

public class RacingCars {


    private List<RacingCar> racingCars;

    private RacingCars(List<RacingCar> list) {
        this.racingCars = list;
    }

    public static RacingCars from(List<RacingCar> racingCars) {
        return new RacingCars(racingCars);
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }
}
