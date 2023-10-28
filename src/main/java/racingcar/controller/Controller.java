package racingcar.controller;

import racingcar.model.Car;
import racingcar.view.View;

public class Controller {
    private Car car;
    private View view;

    public Controller() {
        view = new View();
        String[] namesOfCars = view.getNamesOfCars();


    }
}
