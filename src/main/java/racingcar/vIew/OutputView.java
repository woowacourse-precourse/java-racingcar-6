package racingcar.vIew;

import java.util.HashMap;
import java.util.List;

public class OutputView {
    private static final String gameResultOutputMessage = "실행 결과";
    private static final String WinngerOutputMessage = "최종 우승자 : ";

    public static void gameResultMessageOutput() {
        System.out.println(gameResultOutputMessage);
    }

    public void gameReslutOutput(HashMap<String, String> gameResult) {

        for (String car : gameResult.keySet()) {
            System.out.println(car + " : " + gameResult.get(car));
        }
        System.out.println();

    }

    public void WinnerOutput(List<String> winnerResult) {
        System.out.print(WinngerOutputMessage);
        String winners = String.join(", ", winnerResult);
        System.out.print(winners);

    }
}
