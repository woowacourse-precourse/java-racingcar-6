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

    public RacingResult race() {
        List<RacingRoundResult> racingHistory = runRace();
        List<String> winnerNames = getWinnerNames();
        return new RacingResult(winnerNames, racingHistory);
    }

    private List<String> getWinnerNames() {
        int maxPosition = getMaxPosition();
        List<String> winnerNames = new ArrayList<>();
        for (Car car : cars) {
            addIfWinner(car, maxPosition, winnerNames);
        }
        return winnerNames;
    }

    private void addIfWinner(Car car, int maxPosition, List<String> winnerNames) {
        if (car.isPosition(maxPosition)) {
            winnerNames.add(car.getName());
        }
    }

    private int getMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }

    private List<RacingRoundResult> runRace() {
        List<RacingRoundResult> racingResult = new ArrayList<>();
        for (int i = 0; i < roundNumber; i++) {
            List<CarStatus> currentCarStatuses = runRound();
            racingResult.add(new RacingRoundResult(currentCarStatuses));
        }
        return racingResult;
    }

    private List<CarStatus> runRound() {
        moveCars();
        return getCurrentCarStatuses();
    }

    private void moveCars() {
        for (Car car : cars) {
            car.move();
        }
    }

    private List<CarStatus> getCurrentCarStatuses() {
        List<CarStatus> carStatuses = new ArrayList<>();
        for (Car car : cars) {
            carStatuses.add(car.getCurrentStatus());
        }
        return carStatuses;
    }
}
