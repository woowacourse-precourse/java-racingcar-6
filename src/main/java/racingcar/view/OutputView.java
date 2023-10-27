package racingcar.view;

import racingcar.domain.Cars;

public class OutputView {
    private static final int INITIAL_COUNT = 0;
    private static final String EXECUTION_RESULT_OUTPUT_MESSAGE = "실행 결과";
    private static final String DASH = "-";

    public void printResultMessage() {
        System.out.println("\n" + EXECUTION_RESULT_OUTPUT_MESSAGE);
    }

    public void printExecutionResult(Cars cars) {
        for (String carName : cars.getCarNameList()) {
            int advanceCount = cars.getCarAdvanceCount(carName);
            System.out.print(carName + " : ");
            printDash(advanceCount);
            System.out.println();
        }
        System.out.println();
    }

    private void printDash(int count) {
        int currentCount = INITIAL_COUNT;
        while (currentCount++ < count) {
            System.out.print(DASH);
        }
    }
}
