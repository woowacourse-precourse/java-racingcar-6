package racingcar.view;

import java.util.List;
import java.util.Map;

public class PrintMessage {
  	private static final String RESULT_MESSAGE = "\n실행 결과";
    private static final String WINNER_MESSAGE = "최종 우승자 : %s";
    private static final String CAR_MOVEING_HISTROY = "-";
    private static final String COLON = " : ";

    public void printNotice() {
        System.out.println(RESULT_MESSAGE);
    }

    public void printRacingResult(Map<String, Integer> history) {
        for (String name : history.keySet()) {
            Integer positionValue = history.get(name);
            System.out.println(
                    name + COLON + CAR_MOVEING_HISTROY.repeat(positionValue));
        }
        System.out.println();
    }

    public void printWinner(List<String> winners) {
        String winnerNames = winners.toString();
        System.out.printf(WINNER_MESSAGE, winnerNames.substring(1, winnerNames.length()-1));
    }
}
