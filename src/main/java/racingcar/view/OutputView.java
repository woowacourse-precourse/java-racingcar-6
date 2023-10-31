package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private final static String resultMessage = "실행 결과";
    private final static String winnerMessage = "최종 우승자";

    public void roundResult(List<String> racingResult) {
        System.out.println("\n" + resultMessage);

        String result = racingResult.stream()
                .collect(Collectors.joining("\n"));

        System.out.println(result);

    }

    public void getWinnerMessage(List<String> winnerList) {
        String winner = winnerMessage + " : " + String.join(", ", winnerList);
        System.out.println(winner);
    }
}
