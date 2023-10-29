package racingcar.controller.subcontroller;

import racingcar.domain.Car;

public class InitializeCarController {
    public Car initializeCar(String name) {
        Car car = new Car(name);
        System.out.println(car.getName() + "이 생성됨.");
        return car;
    }
}
