package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {
    private List<RacingCar> racingCars;

    private RacingCars(final List<String> names) {
        this.racingCars = new ArrayList<>();

        for (String name : names) {
            this.racingCars.add(RacingCar.createRacingCar(name));
        }
    }

    public static RacingCars createRacingCars(final List<String> names) {
        return new RacingCars(names);
    }

    public void tryMoveCars() {
        for (RacingCar racingCar : this.racingCars) {
            racingCar.tryMove();
        }
    }

    public List<String> getResults() {
        List<String> results = new ArrayList<>();

        for (RacingCar racingCar : this.racingCars) {
            results.add(racingCar.getResult());
        }

        return results;
    }

    public List<String> getWinners() {
        List<String> winners = new ArrayList<>();
        int maxPosition = getMaxPosition();

        for (RacingCar racingCar : this.racingCars) {
            if (racingCar.getPosition() == maxPosition) {
                winners.add(racingCar.getName());
            }
        }

        return winners;
    }

    private int getMaxPosition() {
        int maxPosition = 0;

        for (RacingCar racingCar : this.racingCars) {
            if (racingCar.getPosition() > maxPosition) {
                maxPosition = racingCar.getPosition();
            }
        }

        return maxPosition;
    }
}
