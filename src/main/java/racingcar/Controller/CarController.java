package racingcar.Controller;

import racingcar.Model.CarModel;

public class CarController {

    private final CarModel car;

    public CarController(CarModel car) {

        this.car = car;
    }

    public void goFoward(){

        car.goForwardDistance();
    }

}