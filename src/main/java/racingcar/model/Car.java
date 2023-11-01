package racingcar.model;

import racingcar.CarDTO;

public class Car {
    public CarDTO car;

    public Car(CarDTO car) {
        this.car = car;
    }

    public void Forward(){
        int curProgress=car.getForwardProgress();
        curProgress++;
        car.setForwardProgress(curProgress);
    }
}
