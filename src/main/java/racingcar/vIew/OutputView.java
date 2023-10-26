package racingcar.vIew;

import java.util.HashMap;
import java.util.List;

public class OutputView {
    private static final String gameResultOutputMessage = "실행 결과";
    private static final String WinngerOutputMessage = "최종 우승자 : ";

    public static void gameResultMessageOutput() {
        System.out.println(gameResultOutputMessage);
    }

    public static void gameReslutOutput(HashMap<String, String> gameResultMap) {

        for (String car : gameResultMap.keySet()) {
            System.out.println(car + " : " + gameResultMap.get(car));
        }
        System.out.println();

    }

    public static void WinnerOutput(List<String> winnerList) {
        System.out.print(WinngerOutputMessage);
        String winners = String.join(",", winnerList);
        System.out.print(winners);

    }
}
