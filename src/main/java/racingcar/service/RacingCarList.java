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

    public static void moveAllRacingCarsForward(List<RacingCar> racingCars) {
        for (RacingCar racingCar : racingCars) {
            racingCar.moveForward();
        }
    }

    public static List<String> generateAllRacingCarsStatusList(List<RacingCar> racingCars) {
        List<String> carStatus = new ArrayList<>();
        for (RacingCar racingCar : racingCars) {
            carStatus.add(racingCar.getCarName() + " : " + racingCar.convertDistanceToString());
        }
        return carStatus;
    }

}