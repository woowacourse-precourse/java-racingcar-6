package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;

public class RacingCarService {
    private static final int MIN_RANDOM_NUMBER = 0;
    private static final int MAX_RANDOM_NUMBER = 9;
    private static final int MIN_MOVE_PROBABILITY = 4;

    public List<Car> convertCarNames(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            Car car = Car.createZeroProgressCar(carName);
            cars.add(car);
        }
        return cars;
    }

    public void raceCar(List<Car> cars) {
        for (Car car : cars) {
            if (willMoveForward()) {
                car.moveForward();
            }
        }
    }

    private boolean willMoveForward() {
        int RandomNumber = Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
        return RandomNumber >= MIN_MOVE_PROBABILITY;
    }

    public List<Car> calculatWinner(List<Car> cars) {
        int maxProgress = cars.stream()
                .mapToInt(Car::getProgress)
                .max()
                .orElse(0);

        List<Car> winners = cars.stream()
                .filter(car -> car.getProgress() == maxProgress)
                .toList();

        return winners;
    }
}
