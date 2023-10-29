package racingcar.factory;

import racingcar.vo.Car;

public interface Factory {

    Car makeTuningCar(Car oldCar);
}
