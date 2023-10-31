package racingcar.view;

import racingcar.model.Car;

import java.util.ArrayList;
import java.util.List;

public class OutputView {

    public static void carsStatus(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(carStatus(car));
        }
        System.out.println();
    }

    private static String carStatus(Car car){
        return car.getCarName() + " : " + car.getPosition();
    }
}
