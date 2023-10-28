package controller;

import model.Car;
import model.CarsNameConverter;
import view.InputView;

import java.util.ArrayList;
import java.util.List;

public class CarController {

    public List<Car> makeCars() {
        List<String> carsNameAsList = convertCarsNameStringToList();
        List<Car> cars = new ArrayList<>();
        for (String carName : carsNameAsList) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    private List<String> convertCarsNameStringToList() {
        String carsNameAsString = InputView.inputCarsName();
        List<String> carsNameAsList = CarsNameConverter.convertStringToList(carsNameAsString);
        return carsNameAsList;
    }
}
