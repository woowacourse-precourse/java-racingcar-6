package racingcar.manager.controller;

import java.util.List;
import racingcar.manager.model.Car;
import racingcar.manager.view.CarView;

public class CarController {
    private final CarView carView = new CarView();
    public List<Car> getCars(){
        List<String> carNames = carView.inputCarNames();
        return new Car().getCarList(carNames);
    }

}
