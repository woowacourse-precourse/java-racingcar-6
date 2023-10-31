package racingcar.view;

import java.util.List;
import racingcar.domain.Player;

public class OutputView {

    private static final String GAME_START_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String GAME_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String RESULT_PRINT_MESSAGE = "실행 결과";
    private static final String WINNER_MESSAGE = "최종 우승자 : %s";

    public void printGameStart() {
        System.out.println(GAME_START_MESSAGE);
    }

    public void printGameCount() {
        System.out.println(GAME_COUNT_MESSAGE);
    }

    public void printGameResult() {
        printNewLine();
        System.out.println(RESULT_PRINT_MESSAGE);
    }

    public void printPartialResults(List<Player> playerList) {
        for (Player player : playerList) {
            System.out.println(player.name + " : " + "-".repeat(player.score));
        }
        printNewLine();
    }

    public void printFinalResults(List<String> winners) {

        if (!winners.isEmpty()) {
            String winnerList = String.join(", ", winners);
            System.out.printf(WINNER_MESSAGE, winnerList);
        }
    }
    private void printNewLine() {
        System.out.println();
    }
}
