package racingcar;

import java.util.List;

public class OutputHandler {
    public static void printEachResult(CarGroup carGroup) {
        List<Car> carList = carGroup.getCarList();
        for (Car car : carList) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getDistance()));
        }
        System.out.println();
    }
}
