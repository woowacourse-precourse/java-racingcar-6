package racingcar.factory.impl;

import racingcar.factory.Factory;
import racingcar.service.RacingService;
import racingcar.vo.Car;

public class CarFactory implements Factory {

    private final RacingService racingService;

    public CarFactory(RacingService racingService) {
        this.racingService = racingService;
    }

    @Override
    public Car makeTuningCar(Car oldCar) {
        if (racingService.isCanGoOneSpace()) {
            return oldCar.makeNewCar();
        }
        return oldCar;
    }
}
