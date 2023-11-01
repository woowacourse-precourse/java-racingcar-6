package racingcar;


import java.util.ArrayList;
import java.util.List;

public class Racing {

    private final List<Car> cars;
    private final int roundNumber;

    public Racing(List<Car> cars, int roundNumber) {
        this.cars = cars;
        this.roundNumber = roundNumber;
    }

    public List<RacingRoundResult> race() {
        List<RacingRoundResult> racingResult = new ArrayList<>();
        for (int i = 0; i < roundNumber; i++) {
            racingResult.add(runRound());
        }
        return racingResult;
    }

    private RacingRoundResult runRound() {
        moveCars();
        return new RacingRoundResult(createRacingRoundResult());
    }

    private void moveCars() {
        for (Car car : cars) {
            car.move();
        }
    }

    private List<CarStatus> createRacingRoundResult() {
        List<CarStatus> carStatuses = new ArrayList<>();
        for (Car car : cars) {
            carStatuses.add(car.getCurrentStatus());
        }
        return carStatuses;
    }
}
