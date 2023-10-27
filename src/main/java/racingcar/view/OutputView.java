package racingcar.view;

import racingcar.model.Cars;

public class OutputView {
    private static final String EXECUTE_RESULT = "실행 결과";

    public static void startDisplayRoundResults() {
        System.out.println(EXECUTE_RESULT);
    }

    public static void displayRoundResult(Cars cars) {
        System.out.println(cars.generateRoundResultString());
    }
}
