package racingcar;

import java.util.Map;

public class OutputView {

    public void printGameResult(Map<String, Integer> moveResult, boolean printPrefix) {
        final String RESULT_PREFIX = "실행 결과";
        final String ONE_STEP = "-";
        final String DELIMITER = " : ";

        if (printPrefix) {
            System.out.println();
            System.out.println(RESULT_PREFIX);
        }

        for (Map.Entry<String, Integer> resultOfCar : moveResult.entrySet()) {
            String name = resultOfCar.getKey();
            StringBuilder steps = new StringBuilder();
            for (int i = 0; i < resultOfCar.getValue(); i++) {
                steps.append(ONE_STEP);
            }
            System.out.println(name + DELIMITER + steps);
        }
        System.out.println();
    }

    public void printGameWinner(String winnerResult) {
        final String WINNER_PREFIX = "최종 우승자 : ";

        System.out.println(WINNER_PREFIX + winnerResult);
    }
}
