package racingcar.view;

import racingcar.model.Car;

import java.util.List;

import static racingcar.constants.StringStore.*;

public class Output {
    public void printResultByIteration(List<Car> carList) {
        for (Car car : carList) {
            System.out.println(car.getName() + " : " + car.getLocationSymbol());
        }
        System.out.println();
    }
}
