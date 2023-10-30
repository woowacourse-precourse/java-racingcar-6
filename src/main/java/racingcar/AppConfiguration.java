package racingcar;

import racingcar.domain.car.CarListFactory;
import racingcar.domain.round.RoundFactory;

public class AppConfiguration {
    private CarListFactory carListFactory() {
        return new CarListFactory();
    }

    private RoundFactory roundFactory() {
        return new RoundFactory();
    }

    public GameManager gameManager() {
        return new GameManager(carListFactory(), roundFactory());
    }
}
