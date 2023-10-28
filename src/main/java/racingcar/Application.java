package racingcar;

import racingcar.input.Car;
import racingcar.input.Count;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Car car = new Car();
        Count count = new Count();
        List<String> names = car.inputCar();
        int num = count.inputCount();
        System.out.println(names.toString() + num);
    }
}
