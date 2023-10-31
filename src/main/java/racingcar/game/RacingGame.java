package racingcar.game;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;
import racingcar.utils.RandomUtils;

public class RacingGame {
    private static final int RANDOM_MOVE_LIMIT = 4;
    private static final int INITIAL_DISTANCE = 0;
    private final List<Car> carList;

    public RacingGame(String[] carNames) {
        this.carList = new ArrayList<>();
        for (String carName : carNames) {
            carList.add(new Car(carName, INITIAL_DISTANCE));
        }
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void proceedRound() {
        for (Car car : carList) {
            int number = RandomUtils.getRandomNumber();
            if (canMove(number)) {
                car.move();
            }
        }
    }

    private boolean canMove(int number) {
        if (number >= RANDOM_MOVE_LIMIT) {
            return true;
        }
        return false;
    }

    public List<Car> getWinners() {
        int maxDistance = carList.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElse(Integer.MIN_VALUE);

        return carList.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .collect(Collectors.toList());
    }
}

