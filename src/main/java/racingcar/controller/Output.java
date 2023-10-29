package racingcar.controller;

import racingcar.model.CarObject;
import racingcar.model.CarService;

public class Output {
    private final CarService service = CarService.getInstance();

    public int getEpoch() {
        return service.epoch;
    }

    public int getSize() {
        return CarObject.size;
    }

    public CarObject getInstance() {
        return CarObject.getInstance();
    }

    public CarService getService() {
        return CarService.getInstance();
    }
}
