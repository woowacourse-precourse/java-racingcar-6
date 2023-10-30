package racingcar.controller.subcontroller;

import racingcar.domain.Car;

public class InitializeCarController {
    public Car initializeCar(String name, int count) {
        Car car = new Car(name, count);
        System.out.println(car.getName() + "이 생성됨. (이동을 시도할 횟수: " + car.getCount() + "회)");
        return car;
    }
}
