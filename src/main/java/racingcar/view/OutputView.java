package racingcar.view;

import java.util.ArrayList;
import java.util.List;

public class OutputView {
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String WINNER_MESSAGE_FORMAT = "최종 우승자 : %s";

    private static final OutputView instance = new OutputView();

    public static OutputView getInstance() {
        return instance;
    }

    private OutputView() {
    }

    public void printResult(int totalRound, List<String> carNames, List<List<Integer>> roundScores, List<String> winnerNames) {
        System.out.println();
        System.out.println(RESULT_MESSAGE);
        printTotalRoundResult(totalRound, carNames, roundScores);
        printWinnerMessage(winnerNames);
    }

    private void printTotalRoundResult(int totalRound, List<String> carNames, List<List<Integer>> roundScores) {
        String resultMessageFormat = createRoundResultMessageFormat(carNames);

        for (int i = 0; i < totalRound; i++) {
            printRoundResult(roundScores, i, resultMessageFormat);
        }
    }

    private String createRoundResultMessageFormat(List<String> carNames) {
        StringBuilder sb = new StringBuilder();
        for (String name : carNames) {
            sb.append(name + " : %s\n");
        }
        return sb.toString();
    }

    private void printRoundResult(List<List<Integer>> roundScores, int i, String resultMessageFormat) {
        List<String> roundData = new ArrayList<>();
        for (int j = 0; j < roundScores.size(); j++) {
            String bars = "-".repeat(roundScores.get(j).get(i));
            roundData.add(bars);
        }
        System.out.println(String.format(resultMessageFormat, roundData.toArray()));
    }

    private void printWinnerMessage(List<String> winnerNames) {
        if (winnerNames.size() == 1) {
            String winnerMessage = String.format(WINNER_MESSAGE_FORMAT, winnerNames.toArray());
            System.out.println(winnerMessage);
            return;
        }
        String winnerNamesString = String.join(", ", winnerNames);
        System.out.println(String.format(WINNER_MESSAGE_FORMAT, winnerNamesString));
    }
}
