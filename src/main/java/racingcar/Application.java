package racingcar;

import input.Car;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Car car = new Car();
        List<String> names = car.inputCar();
        System.out.println(names.toString());
    }
}
