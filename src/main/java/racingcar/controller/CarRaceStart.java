package racingcar.controller;

import racingcar.model.CarObject;

public class CarRaceStart {
    public static void exe() {
        CarAction car = new CarAction();
        car.inputCarName();
        car.inputEpoch();

        for(int i = 0; i < CarObject.epoch; i++) {
            car.carAction();
        }
    }
}
