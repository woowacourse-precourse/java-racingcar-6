package racingcar.service;

import racingcar.model.Car;

public class CarService {

    private  Car car;
    public CarService() {
    }

    public void createCar(String[] cars){
        for(String carName : cars){
            car = Car.createCar(carName);
        }
    }
}
