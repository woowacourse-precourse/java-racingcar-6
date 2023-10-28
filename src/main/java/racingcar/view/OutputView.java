package racingcar.view;

import java.util.ArrayList;
import java.util.List;

public class OutputView {
    private static final String ASK_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ASK_TOTAL_ROUND_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String WINNER_MESSAGE_FORMAT = "최종 우승자 : %s";

    public static void askCarNames() {
        System.out.println(ASK_NAME_MESSAGE);
    }

    public static void askTotalRound() {
        System.out.println(ASK_TOTAL_ROUND_MESSAGE);
    }

    public static void printResult(int totalRound, List<String> carNames, List<List<Integer>> roundScores, List<String> winnerNames) {
        System.out.println();
        System.out.println(RESULT_MESSAGE);

        //라운드 결과 출력
        StringBuilder sb = new StringBuilder();
        for (String name : carNames) {
            sb.append(name + " : %s\n");
        }
        String resultMessageFormat = sb.toString();


        for (int i = 0; i < totalRound; i++) {
            List<String> roundData = new ArrayList<>();
            for (int j = 0; j < roundScores.size(); j++) {
                String bars = "-".repeat(roundScores.get(j).get(i));
                roundData.add(bars);
            }
            System.out.println(String.format(resultMessageFormat, roundData.toArray()));
        }

        //최종 우승자 출력
        if (winnerNames.size() == 1) {
            String winnerMessage = String.format(WINNER_MESSAGE_FORMAT, winnerNames.toArray());
            System.out.println(winnerMessage);
            return;
        }
        String winnerNamesString = String.join(", ", winnerNames);
        System.out.println(String.format(WINNER_MESSAGE_FORMAT, winnerNamesString));
    }
}
