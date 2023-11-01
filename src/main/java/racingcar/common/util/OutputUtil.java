package racingcar.common.util;

import racingcar.Car;

import java.util.List;

public class OutputUtil {
    public void readResult(List<Car> cars) {
        for (Car car : cars) {
            printCarForwardingResult(car);
        }
        System.out.println();
    }

    private void printCarForwardingResult(Car car) {
        System.out.print(car.getName() + " : ");
        printSlash(car.getForwardCnt());
    }

    private void printSlash(int slashCnt) {
        for (int i = 0; i < slashCnt; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
