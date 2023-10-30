package racingcar;

import racingcar.domain.car.CarListFactory;

public class AppConfiguration {
    public CarListFactory carListFactory() {
        return new CarListFactory();
    }

    public GameManager gameManager() {
        return new GameManager(carListFactory());
    }
}
