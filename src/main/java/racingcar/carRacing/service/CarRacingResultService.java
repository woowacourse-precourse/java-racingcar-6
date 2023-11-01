package racingcar.carRacing.service;

import java.util.List;
import racingcar.car.model.Car;

public class CarRacingResultService {

    static public void printCurrentState(List<Car> cars) {
        for (Car car : cars) {
            printCarState(car);
        }
    }

    static private void printCarState(Car car) {
        String name = car.getName();
        Integer position = car.getPosition();

        System.out.print("\n\n" + name + " : ");
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.print("\n");
    }

}
