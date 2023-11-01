package racingcar;


import java.util.ArrayList;
import java.util.List;

public class Racing {

    private static final int MIN_RANDOM_BOUND = 0;
    private static final int MAX_RANDOM_BOUND = 9;
    private static final int MOVING_THRESHOLD = 4;

    private final List<Car> cars;
    private final int roundNumber;
    private final MovingStrategy movingStrategy;

    public Racing(List<Car> cars, int roundNumber) {
        this.cars = cars;
        this.roundNumber = roundNumber;
        this.movingStrategy = new ThresholdRandomMover(MIN_RANDOM_BOUND, MAX_RANDOM_BOUND, MOVING_THRESHOLD);
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
            car.move(movingStrategy);
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
