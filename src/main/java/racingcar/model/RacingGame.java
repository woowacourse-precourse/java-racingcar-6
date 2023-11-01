package racingcar.model;

import static racingcar.model.Car.RANDOM_NUMBER_RANGE_END;
import static racingcar.model.Car.RANDOM_NUMBER_RANGE_START;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RacingGame {

    public static final int CAR_NAME_MAX_LENGTH = 5;
    public static final int CAR_MAX_NUM = 10;

    private List<Car> cars;
    private int gameCount;

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public void setGameCount(int gameCount) {
        this.gameCount = gameCount;
    }

    public int getGameCount() {
        return gameCount;
    }

    public void moveCars() {
        cars.forEach(c -> {
            int n = Randoms.pickNumberInRange(RANDOM_NUMBER_RANGE_START, RANDOM_NUMBER_RANGE_END);
            c.moveOrStop(n);
        });
    }

    public List<String> getAllCarsTrail() {
        return cars.stream().map(Car::getCarTrail).toList();
    }

    public void playOneTurn() {
        moveCars();
    }

    public List<Car> findWinners() {
        int maxPosition = cars.stream().mapToInt(Car::getPosition).max().orElse(0);
        return cars.stream().filter(car -> car.getPosition() == maxPosition).toList();
    }
}
