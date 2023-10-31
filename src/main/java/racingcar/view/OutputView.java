package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Winners;

public class OutputView {
    private static final int INITIAL_COUNT = 0;
    private static final String EXECUTION_RESULT_OUTPUT_MESSAGE = "실행 결과";
    private static final String FINAL_WINNER_OUT_MESSAGE = "최종 우승자 : ";
    private static final String FINAL_WINNER_SEPARATOR = ", ";
    private static final String DASH = "-";

    public void printResultMessage() {
        System.out.println("\n" + EXECUTION_RESULT_OUTPUT_MESSAGE);
    }

    public void printExecutionResult(Cars cars) {
        for (Car car : cars.getCarList()) {
            String name = car.getName();
            int advanceCount = car.getAdvanceCount();
            System.out.print(name + " : ");
            printDash(advanceCount);
            System.out.println();
        }
        System.out.println();
    }

    public void printFinalWinner(Winners winners) {
        System.out.print(FINAL_WINNER_OUT_MESSAGE);
        for (Car car : winners.getWinners()) {
            System.out.print(car.getName());
            printFinalWinnerToDistinguish(winners, car);
        }
    }

    private void printDash(int count) {
        int currentCount = INITIAL_COUNT;
        while (currentCount++ < count) {
            System.out.print(DASH);
        }
    }

    private void printFinalWinnerToDistinguish(Winners winners, Car car) {
        if (!winners.isLastCar(car)) {
            System.out.print(FINAL_WINNER_SEPARATOR);
        }
    }
}
