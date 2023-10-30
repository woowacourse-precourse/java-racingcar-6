package racingcar.service;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.CarNameSeperator;
import racingcar.domain.Cars;
import racingcar.utils.RandomNumberGenerator;

public class RacingCarService {

    private final CarNameSeperator carNameSeperator;
    private final RandomNumberGenerator randomNumberGenerator;

    public RacingCarService() {
        this.carNameSeperator = new CarNameSeperator();
        this.randomNumberGenerator = new RandomNumberGenerator();
    }

    public Cars saveCarName(final String input) {
        List<String> seperatedCarNames = carNameSeperator.seperateCarNames(input);
        Cars cars = new Cars(seperatedCarNames.stream().map(Car::new).toList());
        return cars;
    }

    public Cars moveCar(final Cars cars) {
        judgeMoveCar(cars);
        return cars;
    }

    private void judgeMoveCar(final Cars cars) {
        for (Car car : cars.getCars()) {
            if (randomNumberGenerator.isIncreseDistance()) {
                car.increaseDistance();
            }
        }
    }
}
