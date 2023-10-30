package racingcar;

import racingcar.domain.car.CarsFactory;
import racingcar.domain.round.RoundFactory;

public class AppConfiguration {
    private CarsFactory carsFactory() {
        return new CarsFactory();
    }

    private RoundFactory roundFactory() {
        return new RoundFactory();
    }

    public GameManager gameManager() {
        return new GameManager(carsFactory(), roundFactory());
    }
}
