package racingcar.service;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.utils.CarNameSeperator;
import racingcar.utils.JudgementRandomGenerator;

public class RacingCarService {

    private final CarNameSeperator carNameSeperator;
    private final JudgementRandomGenerator judgementRandomGenerator;

    public RacingCarService(CarNameSeperator carNameSeperator, JudgementRandomGenerator judgementRandomGenerator) {
        this.carNameSeperator = carNameSeperator;
        this.judgementRandomGenerator = judgementRandomGenerator;
    }

    public Cars saveCarName(final String input) {
        final List<String> seperatedCarNames = carNameSeperator.separateCarNames(input);
        return new Cars(seperatedCarNames.stream().map(Car::new).toList());
    }

    public void moveCar(final Cars cars) {
        judgeMoveCar(cars);
    }

    private void judgeMoveCar(final Cars cars) {
        for (Car car : cars.getCars()) {
            if (judgementRandomGenerator.isIncreaseDistance()) {
                car.increaseDistance();
            }
        }
    }
}
