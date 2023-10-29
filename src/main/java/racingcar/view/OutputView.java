package racingcar.view;

import java.util.ArrayList;

public class OutputView {
    public static String showExecutionResultsHeader() {
        return "실행 결과";
    }

    public static String showExecutionResults(ArrayList<String> carNames, ArrayList<Integer> carGoingCount) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < carNames.size(); i++) {
            result.append(carNames.get(i)).append(" : ");
            for (int j = 0; j < carGoingCount.get(i); j++) {
                result.append("-");
            }
            result.append("\n");
        }
        return result.toString();
    }

    public static String showWinner(String winners) {
        return "최종 우승자 : " + winners;
    }
}