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

    public List<Car> start(List<Car> cars) {
        for (Car car : cars) {
            tryMove(car);
        }

        return cars;
    }

    private void tryMove(Car car) {
        int randomValue = numberGenerator.generate();
        if (RandomConstants.MINIMUM_MOVE_THRESHOLD <= randomValue && randomValue <= RandomConstants.END_NUMBER) {
            car.addPosition();
        }
    }
}
