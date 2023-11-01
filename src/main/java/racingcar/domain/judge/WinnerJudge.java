package racingcar.domain.judge;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;

public class WinnerJudge {

    private final Cars cars;

    public WinnerJudge(Cars cars) {
        this.cars = cars;
    }

    public WinnerCars judge() {
        long maxForwardCount = findMaxForwardCount();

        List<Car> winnerCars = new ArrayList<>();

        for (Car car : this.cars.getCars()) {
            if (car.matchesForwardCount(maxForwardCount)) {
                winnerCars.add(car);
            }
        }

        return new WinnerCars(winnerCars);
    }

    private long findMaxForwardCount() {
        return this.cars.getCars()
                .stream()
                .mapToLong(Car::getForwardCount)
                .max()
                .orElse(0L);
    }

}
