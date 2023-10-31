package racingcar.car.controller;

import java.util.HashMap;
import java.util.List;
import racingcar.car.model.Car;
import racingcar.car.view.CarView;

public class CarController {

    private CarView carView = new CarView();
    public CarController(){
        List<String> carNames = carView.inputCarNames();
        for (String carName : carNames) {
            Car car = new Car(carName, 0);
        }

    }
}
