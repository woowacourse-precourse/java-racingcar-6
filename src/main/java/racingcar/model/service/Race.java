package racingcar.model.service;

import java.util.List;

import racingcar.model.Car;
import racingcar.model.NumberGenerator;
import racingcar.util.constants.RandomConstants;

public class Race {
    private final NumberGenerator numberGenerator;

    public Race(final NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public List<Car> start(final List<Car> cars) {
        for (Car car : cars) {
            tryMove(car);
        }

        return cars;
    }

    private void tryMove(final Car car) {
        int randomValue = numberGenerator.generate();
        if (RandomConstants.MINIMUM_MOVE_THRESHOLD <= randomValue && randomValue <= RandomConstants.END_NUMBER) {
            car.addPosition();
        }
    }

    public static WinnerResponse getWinner(final List<Car> cars) {
        int maxDistance = cars.get(0).getDistance();
        for (Car car : cars) {
            if (car.getDistance() > maxDistance) {
                maxDistance = car.getDistance();
            }
        }

        return WinnerResponse.from(cars, maxDistance);
    }
}
