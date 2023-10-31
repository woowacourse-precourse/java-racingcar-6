package racingcar.model;

import static racingcar.model.RandomNumberGenerator.isRacingCarProceed;

import java.util.ArrayList;
import java.util.List;
import racingcar.manager.Names;

public class RacingCars {

    private final List<RacingCar> racingCars;

    private RacingCars(List<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }

    public static RacingCars ofNames(Names names) {
        return new RacingCars(createCarsWithName(names));
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

    public int getHighestScore() {
        int highestScore = -1;
        for (RacingCar racingCar: racingCars) {
            highestScore = Integer.max(highestScore, racingCar.getScore());
        }

        return highestScore;
    }

    private static List<RacingCar> createCarsWithName(Names names) {
        List<RacingCar> cars = new ArrayList<>();
        for (String name : names.names()) {
            cars.add(RacingCar.nameOf(name));
        }

        return cars;
    }
}
