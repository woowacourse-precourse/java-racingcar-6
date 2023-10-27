package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {

    private final List<RacingCar> racingCarList;

    public RacingCars(List<RacingCar> racingCarList) {
        this.racingCarList = racingCarList;
    }

    public RacingCars init(List<String> carNameList) {
        List<RacingCar> initRacingCarList = new ArrayList<>();
        for (String carName : carNameList) {
            initRacingCarList.add(RacingCar.init(carName));
        }
        return new RacingCars(initRacingCarList);
    }
}
