package racingcar.view;

import java.util.List;

public class OutputView {
    private static final String RESULT_ROUND_MESSAGE = "\n" + "실행 결과" + "\n";
    private static final String WINNER_MESSAGE = "최종 우승자 : ";
    private static final StringBuilder stringBuilder = new StringBuilder();

    public void printResultMassage() {
        stringBuilder.append(RESULT_ROUND_MESSAGE);
    }

    public void printRoundGameResult(StringBuilder eachResultBuilder) {
        System.out.println(eachResultBuilder);
        stringBuilder.setLength(0);
    }

    public void printFinalWinner(List<String> winnerNames) {
        String output = formatWinnerNames(winnerNames);
        stringBuilder.append("\n").append(WINNER_MESSAGE).append(output);
        System.out.println(stringBuilder);
    }

    private String formatWinnerNames(List<String> winnerNames) {
        return String.join(", ", winnerNames);
    }

}
