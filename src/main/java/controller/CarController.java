package controller;

import domain.Cars;
public class CarController {
    public Cars createCars(String[] carNames){
        return new Cars(carNames);
    }
}
