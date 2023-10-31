package racingcar.car;

import java.util.List;
import racingcar.io.PrintHandler;
import racingcar.util.RandomManipulator;

public class CarMover {
    public static void moveCarsIterator(List<Car> cars, int trialNum) {
        for (int i = 0; i < trialNum; i++) {
            moveCars(cars);
            PrintHandler.resultRunning(cars);
        }
    }
    private static void moveCars(List<Car> cars) {
        for (Car car : cars) {
            if (RandomManipulator.isMove()) {
                car.move();
            }
        }
        PrintHandler.resultRunning(cars);
    }
}
