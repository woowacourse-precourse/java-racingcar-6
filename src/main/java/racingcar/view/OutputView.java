package racingcar.view;

import static racingcar.view.OutputMessage.*;

import java.util.List;

public class OutputView {
    public static void printResult(List<String> resultList) {
        for (String result : resultList) {
            System.out.println(result);
        }
    }

    public static void printResult(String result) {
        System.out.print(result);
    }

    public static void printWinner(List<String> winnerList) {
        String finalResult = makeFinalWinnerOutputStatement(winnerList);
        System.out.print(finalResult);
    }

    public static String makeFinalWinnerOutputStatement(List<String> winnerList) {
        StringBuilder result = new StringBuilder();

        result.append(FINAL_RESULT.getOutputMessage());

        String winners = String.join(",", winnerList);

        result.append(winners);

        return result.toString();
    }
}
