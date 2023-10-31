package racingcar.car;

import racingcar.car.Car;

public class CarFactory {
    public static Car getNewCarInstance(){
        return new Car();
    }
}