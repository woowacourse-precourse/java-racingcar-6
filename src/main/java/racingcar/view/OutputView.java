package racingcar.view;

import static racingcar.view.constants.Notice.RESULT;

import racingcar.domain.Car;

public class OutputView {
    public static void printResult() {
        System.out.println(RESULT);
    }

    public static void printResult(Car car) {
        System.out.println(car.toString());
    }

    public static void printWinner() {

    }
}
