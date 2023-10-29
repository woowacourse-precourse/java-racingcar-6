package racingcar;

import racingcar.domain.Car;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        Car car = new Car();
        List<String> carNames = car.getNames();
        System.out.println(carNames);
    }
}
