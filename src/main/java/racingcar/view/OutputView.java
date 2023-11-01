package racingcar.view;

import racingcar.domain.Cars;

public class OutputView {

    public static void printStartToShowResult() {
        System.out.println("실행 결과");
    }

    public static void printMovingResults(Cars cars) {
        System.out.println(cars);
        System.out.println();
    }
}
