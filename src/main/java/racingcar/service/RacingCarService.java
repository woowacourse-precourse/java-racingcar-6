package racingcar.service;

import java.util.List;
import racingcar.utils.JudgementGenerator;
import racingcar.domain.Car;
import racingcar.utils.CarNameSeperator;
import racingcar.domain.Cars;
import racingcar.utils.JudgementRandomGenerator;

public class RacingCarService {

    private final CarNameSeperator carNameSeperator;
    private final JudgementGenerator judgementGenerator;
    public RacingCarService() {
        this.carNameSeperator = new CarNameSeperator();
        this.judgementGenerator = new JudgementRandomGenerator();
    }

    public Cars saveCarName(final String input) {
        List<String> seperatedCarNames = carNameSeperator.separateCarNames(input);
        return new Cars(seperatedCarNames.stream().map(Car::new).toList());
    }

    public void moveCar(final Cars cars) {
        judgeMoveCar(cars);
    }

    private void judgeMoveCar(final Cars cars) {
        for (Car car : cars.getCars()) {
            if (judgementGenerator.isIncreaseDistance()) {
                car.increaseDistance();
            }
        }
    }
}
