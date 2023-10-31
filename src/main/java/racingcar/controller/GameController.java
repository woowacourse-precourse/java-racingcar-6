package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.GameManager;
import racingcar.view.InputView;

public class GameController {

    InputView inputView = new InputView();
    Cars cars;

    public void gameStart() {
        cars = createCars(inputView.getCarsName());
    }

    public Cars createCars(List<String> carsName) {
        List<Car> carsTempHolder = new ArrayList<>();
        Cars cars;

        for(String carName : carsName) {
            Car car = new Car(carName);
            carsTempHolder.add(car);
        }
        cars = new Cars(carsTempHolder);
        return cars;
    }
}
