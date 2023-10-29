package racingcar.view;

import static racingcar.utils.Console.println;

import java.util.List;

public class OutputView {
    public static final String RESULT_MESSAGE = "실행 결과";
    private static final String RESULT_FORMAT = "%s : %s";
    private static final char GAME_SCORE = '-';
    private static final String FINAL_WINNER = "최종 우승자 : ";
    private static final String COMMA = ",";

    public void printResultMessage() {
        println(RESULT_MESSAGE);
    }

    public void printCarResult(String name, int position) {
        String positionStr = new String(new char[position]).replace('\0', GAME_SCORE);
        println(String.format(RESULT_FORMAT, name, positionStr));
    }

    public void printWinner(List<String> winners) {
        println(winnerMessage(winners));
    }

    private String winnerMessage(List<String> winners) {
        if(winners.size() == 1) {
            return FINAL_WINNER + winners.get(0);
        }
        return FINAL_WINNER + String.join(COMMA, winners);
    }

}
