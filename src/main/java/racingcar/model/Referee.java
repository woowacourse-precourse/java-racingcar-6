package racingcar.model;

import java.util.Collections;
import java.util.List;

public class Referee {
    private List<Car> winner;
    private int winnerStep;

    public void findWinnerStep(RacingCars cars) {
        for (Car car : cars.getAllCars()) {
            if (winnerStep < car.getCurrentPosition()) {
                winnerStep = car.getCurrentPosition();
            }
        }
    }

    public List<Car> winnerResult(RacingCars cars) {
        for (Car car : cars.getAllCars()) {
            if (winnerStep == car.getCurrentPosition()) {
                winner.add(car);
            }
        }
        return Collections.unmodifiableList(winner);
    }


}
