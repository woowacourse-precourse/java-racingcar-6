package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class RacingCarController {
    Cars cars;
    InputView inputView = new InputView();

    public void run() {
        List<Car> collectCars = new ArrayList<>();
        String[] carNames = inputView.carName();
        for (String carName : carNames) {
            collectCars.add(new Car(carName));
        }
        cars = new Cars(collectCars);

        for (Car car : cars.getCars()) {
            System.out.println(car.getCarName()+" "+car.getPosition());
        }
    }
}
