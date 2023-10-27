package racingcar.view;

import java.util.List;
import racingcar.domain.Cars;
import racingcar.domain.Winners;

public class OutputView {
    private static final int INITIAL_COUNT = 0;
    private static final int LAST_INDEX_CHECK_NUMBER = 1;
    private static final String EXECUTION_RESULT_OUTPUT_MESSAGE = "실행 결과";
    private static final String FINAL_WINNER_OUT_MESSAGE = "최종 우승자 : ";
    private static final String FINAL_WINNER_SEPARATOR = ", ";
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

    public void printFinalWinner(Winners winners) {
        List<String> winnerList = winners.getWinners();
        System.out.print(FINAL_WINNER_OUT_MESSAGE);
        for (String carName : winnerList) {
            System.out.print(carName);
            printFinalWinnerToDistinguish(winnerList, carName);
        }
    }

    private void printDash(int count) {
        int currentCount = INITIAL_COUNT;
        while (currentCount++ < count) {
            System.out.print(DASH);
        }
    }

    private void printFinalWinnerToDistinguish(List<String> winnerList, String carName) {
        if ((winnerList.indexOf(carName) + LAST_INDEX_CHECK_NUMBER) < winnerList.size()) {
            System.out.print(FINAL_WINNER_SEPARATOR);
        }
    }
}
