package racingcar.controller;

import java.util.ArrayList;
import racingcar.model.Car;
import racingcar.view.InputView;
import racingcar.service.Exception;

public class GameController {
    public void play() {
        setCar();
    }

    private void setCar() {
        Exception.checkCarName(InputView.InputCarName());
        Car.carList = new ArrayList<>();
        for (String name : Exception.carNames) {
            Car.carList.add(new Car(name));
        }
    }
}
