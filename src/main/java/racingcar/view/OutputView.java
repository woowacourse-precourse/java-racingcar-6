package racingcar.view;

import java.util.List;
import java.util.Stack;
import racingcar.domain.Car;

public class OutputView {

    public void printCars(List<Car> cars) {
        for (Car car: cars) {
            System.out.println(car.getCarInfo());
        }
    }

    public void printCars(Stack<Car> cars) {
        for (Car car: cars) {
            System.out.println(car.getCarInfo());
        }
    }
}
