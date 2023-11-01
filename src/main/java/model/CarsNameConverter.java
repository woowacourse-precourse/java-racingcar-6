package model;

import util.CarsNameValidator;

import java.util.List;

public class CarsNameConverter {
    private static List<String> cars;

    public static List<String> convertStringToList(String carsName) {
        cars = List.of(carsName.split(","));
        CarsNameValidator.checkValidCarsName(cars);
        return cars;
    }
}
