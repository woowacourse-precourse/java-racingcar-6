package racingcar.domain.car.config;

import racingcar.domain.car.carfactory.CarFactory;
import racingcar.domain.car.CarManager;
import racingcar.domain.car.carfactory.InputCarFactory;
import racingcar.domain.car.validator.InputCarFactoryValidator;
import racingcar.domain.victory.config.VictoryConfig;

public class CarConfig {
    private final VictoryConfig victoryConfig;
    private CarFactory cashedCarFactory;
    private CarManager cashedCarManager;

    public CarConfig(VictoryConfig victoryConfig) {
        this.victoryConfig = victoryConfig;
    }

    public CarFactory carFactory() {
        if (cashedCarFactory == null) {
            cashedCarFactory = new InputCarFactory(new InputCarFactoryValidator());
        }
        return cashedCarFactory;
    }

    public CarManager carManager() {
        if (cashedCarManager == null) {
            cashedCarManager = new CarManager(carFactory(), victoryConfig.victoryManager());
        }
        return cashedCarManager;
    }
}
