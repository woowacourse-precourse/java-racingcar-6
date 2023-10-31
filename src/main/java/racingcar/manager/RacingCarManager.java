package racingcar.manager;

import static racingcar.model.RandomNumberGenerator.isRacingCarProceed;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import racingcar.constant.GameStringConstant;
import racingcar.model.RacingCar;

public class RacingCarManager {

    private final List<RacingCar> racingCars;

    private RacingCarManager(List<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }

    public static RacingCarManager ofNames(Names names) {
        return new RacingCarManager(createCarsWithName(names));
    }

    public void playOneRound(/*boolean isRacingCarProceed*/) {
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

    public Names getWinnerNames() {
        List<String> names = new ArrayList<>();
        int winnerScore = getHighestScore();
        for (RacingCar racingCar : racingCars) {
            String name = racingCar.getNameIfCarIsWinner(winnerScore);
            if (!Objects.equals(name, GameStringConstant.BLANK.getValue())) {
                names.add(name);
            }
        }
        return new Names(names);
    }

    private static List<RacingCar> createCarsWithName(Names names) {
        List<RacingCar> cars = new ArrayList<>();
        for (String name : names.names()) {
            cars.add(RacingCar.nameOf(name));
        }

        return cars;
    }

    private int getHighestScore() {
        int highestScore = -1;
        for (RacingCar racingCar : racingCars) {
            highestScore = Integer.max(highestScore, racingCar.getScore());
        }

        return highestScore;
    }
}
