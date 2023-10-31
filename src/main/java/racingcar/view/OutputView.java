package racingcar.view;

import java.util.List;
import java.util.Stack;
import racingcar.domain.Car;

public class OutputView {

    public void printCars(List<Car> cars) {
        for (Car car: cars) {
            System.out.println(car.getCarInfo());
        }
        System.out.println();
    }

    public void printWinners(Stack<Car> cars) {
        System.out.print("최종 우승자 : ");
        System.out.print(cars.get(0).getName());
        for (int i = 1; i < cars.size(); ++i) {
            System.out.print(", " + cars.get(i).getName());
        }
    }
}
