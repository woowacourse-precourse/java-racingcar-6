package racingcar.view;

import java.util.HashMap;
import java.util.List;

/**
 * 경주 결과를 출력하는 기능을 담당합니다.
 */
public class ConsoleResultView implements ResultView {
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String WINNER_MESSAGE_PREFIX = "최종 우승자 : ";
    private final List<HashMap<String, Integer>> raceResult;
    private final List<String> winners;


    public ConsoleResultView(List<HashMap<String, Integer>> raceResult, List<String> winners) {
        this.raceResult = raceResult;
        this.winners = winners;
    }

    public void displayRaceResults() {
        displayMessage(RESULT_MESSAGE);
        for (HashMap<String, Integer> result : raceResult) {
            for (String carName : result.keySet()) {
                displayMessage(carName + " : " + "-".repeat(result.get(carName)));
            }
            displayMessage("");
        }
    }

    public void displayWinners() {
        String winnerNames = String.join(", ", winners);
        displayMessage(WINNER_MESSAGE_PREFIX + winnerNames);
    }

    private void displayMessage(String message) {
        System.out.println(message);
    }
}
