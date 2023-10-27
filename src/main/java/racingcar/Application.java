package racingcar;

import racingcar.domain.Car;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Car car = new Car("aaa");
        System.out.println(car.name);
        System.out.println(car.mileage);
        car.moveForward();
        System.out.println(car.mileage);
    }
}