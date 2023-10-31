package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {

    private List<RacingCar> racingCars;

    public RacingCars(String[] carNames) {
        racingCars = new ArrayList<>();

        for (String carName : carNames) {
            racingCars.add(new RacingCar(carName));
        }
    }

    public List<Result> moveCars(MoveNumGenerator moveNumGenerator) {
        List<Result> results = new ArrayList<>();

        for (RacingCar racingCar : racingCars) {
            racingCar.move(moveNumGenerator.generate());
            results.add(racingCar.makeResult());
        }

        return results;
    }

    public List<Result> findWinners() {

        int maxAdvance = calcMaxAdvance();
        List<Result> results = new ArrayList<>();

        for (RacingCar racingCar : racingCars) {
            if (getAdvance(racingCar) == maxAdvance) {
                results.add(racingCar.makeResult());
            }
        }

        return results;
    }

    private int calcMaxAdvance() {

        int maxAdvance = 0;

        for (RacingCar racingCar : racingCars) {
            maxAdvance = Math.max(getAdvance(racingCar), maxAdvance);
        }

        return maxAdvance;
    }

    private static int getAdvance(RacingCar racingCar) {
        return racingCar.makeResult().getAdvance();
    }
}
