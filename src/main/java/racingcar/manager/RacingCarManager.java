package racingcar.manager;

import static racingcar.model.RandomNumberGenerator.isRacingCarProceed;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.RacingCar;
import racingcar.model.RacingCarsDto;

public class RacingCarManager {

    private final List<RacingCar> racingCars;

    private RacingCarManager(List<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }

    public static RacingCarManager ofNames(Names names) {
        return new RacingCarManager(createCarsWithName(names));
    }

    public void playOneRound() {
        for (RacingCar racingCar : racingCars) {
            if (isRacingCarProceed()) {
                racingCar.addScore();
            }
        }
    }

    public String getScoreBoard() {
        StringBuilder sb = new StringBuilder();

        for (RacingCar racingCar : racingCars) {
            sb.append(racingCar.getCarInfo());
            sb.append("\n");
        }

        return sb.toString();
    }

    private static List<RacingCar> createCarsWithName(Names names) {
        List<RacingCar> cars = new ArrayList<>();
        for (String name : names.names()) {
            cars.add(RacingCar.nameOf(name));
        }

        return cars;
    }
}
