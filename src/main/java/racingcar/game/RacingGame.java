package racingcar.game;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.entity.Car;

public class RacingGame {

    // Game Configuration fields
    private static final int RANDOM_MIN = 0;
    private static final int RANDOM_MAX = 9;
    private static final int THRESHOLD = 4;

    private List<Car> cars;

    private int remainingRounds;

    public RacingGame(List<String> names, int rounds) {
        this.cars = new ArrayList<>();
        names.forEach(n -> cars.add(new Car(n)));
        this.remainingRounds = rounds;
    }

    public void tryToProceedCars() {
        cars.stream()
                .filter(c -> isOverThreshold(generateRandomIntInRange()))
                .forEach(c -> c.proceedSingleUnit());
    }
    private int generateRandomIntInRange() {
        return Randoms.pickNumberInRange(RANDOM_MIN, RANDOM_MAX);
    }
    private boolean isOverThreshold(int generatedInt) {
        return generatedInt >= THRESHOLD;
    }

    public List<Car> getGameProgress() {
        return cars;
    }

    public boolean isFinished() {
        return remainingRounds == 0;
    }

    public List<String> getWinners() {
        if (!isFinished()) {
            return null;
        }
        int maxPosition = 0;
        List<String> winners = new ArrayList<>();
        cars.forEach(car -> updateWinnersByPosition(car, maxPosition, winners));
        return winners;
    }
    private int updateWinnersByPosition(Car car, int currentMaxPosition, List<String> winners) {
        int carPosition = car.getPosition();

        if (carPosition > currentMaxPosition) {
            winners.clear();
            winners.add(car.getName());
            return carPosition;
        } else if (car.getPosition() == currentMaxPosition) {
            winners.add(car.getName());
            return currentMaxPosition;
        } else {
            return currentMaxPosition;
        }
    }
}
