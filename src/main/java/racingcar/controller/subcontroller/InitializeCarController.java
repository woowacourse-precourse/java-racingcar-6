package racingcar.controller.subcontroller;

import racingcar.domain.Car;

public class InitializeCarController {
    public Car initializeCar(String name, int tryCount) {
        Car car = new Car(name, tryCount);
        System.out.println(car.getName() + "이 생성됨. (이동을 시도할 횟수: " + car.getTryCount() + "회)");
        return car;
    }
}
