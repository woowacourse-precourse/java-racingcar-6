package racingcar.common.util;

import racingcar.Car;

import java.util.List;

import static racingcar.common.message.GameConstant.ANNOUNCE_WINNER_MESSAGE;

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

    public void readWinner(List<Car> cars) {
        System.out.print(ANNOUNCE_WINNER_MESSAGE);
        for (int i = 0; i < cars.size(); i++) {
            System.out.print(cars.get(i).getName());
            if (i != cars.size() - 1) {
                System.out.print(", ");
            }
        }
    }
}
