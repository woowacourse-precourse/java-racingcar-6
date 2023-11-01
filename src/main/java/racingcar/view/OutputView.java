package racingcar.view;

import racingcar.model.Car;

import java.util.List;

import static racingcar.constant.RaceMessage.*;

public class OutputView {
    public static void printExecution() {
        System.out.println(EXECUTION_RESULT);
    }

    public void printCarStatus(List<Car> cars) {
        for (Car car : cars) {
            printCarStatusLine(car);
        }
        System.out.println();
    }

    private void printCarStatusLine(Car car) {
        StringBuilder status = new StringBuilder(car.getName() + NAME_INDICATOR);
        for (int i = 0; i < car.getPosition(); i++) {
            status.append(POSITION_INDICATOR);
        }
        System.out.println(status);
    }

    public static void printWinners(List<String> winners) {
        System.out.print(FINAL_WINNER);
        System.out.println(String.join(JOIN_INDICATOR, winners));
    }
}