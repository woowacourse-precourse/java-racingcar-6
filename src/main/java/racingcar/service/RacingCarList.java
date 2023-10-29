package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.RacingCar;

public class RacingCarList {

    public static List<RacingCar> generateRacingCarList(String[] carNames) {
        List<RacingCar> racingCars = new ArrayList<>();

        for (String carName : carNames) {
            racingCars.add(new RacingCar(carName));
        }

        return racingCars;
    }

}