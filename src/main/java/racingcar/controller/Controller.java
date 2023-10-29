package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.Model;
import racingcar.view.View;

public class Controller {
    public Controller() {
        View view = new View();
        Model model = new Model();

        String[] namesOfCars = view.getNamesOfCars();
        List<Car> carList = model.makeCarList(namesOfCars);

        int numberOfAttempts = view.getNumberOfAttempts();

        model.racing(carList, numberOfAttempts);
    }
}
