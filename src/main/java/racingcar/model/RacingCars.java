package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {

    private final List<RacingCar> racingCarList;

    public RacingCars(List<RacingCar> racingCarList) {
        this.racingCarList = racingCarList;
    }

    public static RacingCars init(List<String> carNameList) {
        List<RacingCar> initRacingCarList = new ArrayList<>();
        for (String carName : carNameList) {
            initRacingCarList.add(RacingCar.init(carName));
        }
        return new RacingCars(initRacingCarList);
    }

    public RacingCars move() {
        List<RacingCar> movedRacingCarList = new ArrayList<>();
        for (RacingCar racingCar : racingCarList) {
            RacingCar movedCar = racingCar.move();
            movedRacingCarList.add(movedCar);
        }
        return new RacingCars(movedRacingCarList);
    }

    public List<RacingCar> getRacingCarList() {
        return racingCarList;
    }
}
