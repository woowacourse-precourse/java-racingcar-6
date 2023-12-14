package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.view.console.ConsoleWriter;

public class OutputView {
    public static final String RESULT_NOTICE = "실행 결과";

    public void printResult(Cars cars) {
        ConsoleWriter.printlnMessage(RESULT_NOTICE);
        printCarsStatus(cars);
        ConsoleWriter.println();
    }

    private void printCarsStatus(Cars cars) {
        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            printCarStatus(car, i);
        }
    }

    private void printCarStatus(Car car, int i) {
        String name = car.getName();
        int moved = car.getMoved();
        ConsoleWriter.printlnMessage(name + " : " + "_".repeat(moved));
    }
}
