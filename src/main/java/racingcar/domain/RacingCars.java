package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingCars {
    private final List<Car> cars;

    public RacingCars(List<String> carNames, Engine engine) {
        this.cars = initializeCars(carNames, engine);
    }

    private List<Car> initializeCars(List<String> carNames, Engine engine) {
        List<Car> participateCars = new ArrayList<>();
        for (String carName : carNames) {
            participateCars.add(new Car(carName, engine));
        }
        return participateCars;
    }

    public List<Car> findWinners() {
        long maxTotalMoveCount = calculateMaxTotalMoveCount();
        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getTotalMoveCount() == maxTotalMoveCount) {
                winners.add(car);
            }
        }
        return Collections.unmodifiableList(winners);
    }

    private long calculateMaxTotalMoveCount() {
        long maxTotalMoveCount = 0;
        for (Car car : this.cars) {
            maxTotalMoveCount = Math.max(car.getTotalMoveCount(), maxTotalMoveCount);
        }
        return maxTotalMoveCount;
    }

    public List<Car> doRace() {
        for (Car car : this.cars) {
            car.moveCar();
        }
        System.out.println("레이스 완료: " + this.cars);
        return Collections.unmodifiableList(cars);
    }
}
