package controller;

import domain.Car;
import domain.Cars;
import view.InputView;

public class RaceController {
    private Cars cars;

    public RaceController() {

    }

    public void set() {
        cars = new Cars(InputView.carNames());
        printCarLists();
    }

    private void printCarLists() {
        cars.carsList.stream()
                .map(Car::getCarName)
                .forEach(System.out::println);
    }
}
