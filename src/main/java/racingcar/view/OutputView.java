package racingcar.view;

import java.util.List;
import racingcar.domain.Player;

public class OutputView {

    private static final String GAME_START_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String GAME_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String RESULT_PRINT_MESSAGE = "실행 결과";

    public void printGameStart() {
        System.out.println(GAME_START_MESSAGE);
    }

    public void printGameCount() {
        System.out.println(GAME_COUNT_MESSAGE);
    }

    public void printGameResult() {
        System.out.println();
        System.out.println(RESULT_PRINT_MESSAGE);
    }

    public void printPartialResults(List<Player> playerList) {
        for (Player player : playerList) {
            System.out.println(player.name + " : " + "-".repeat(player.score));
        }
        System.out.println();
    }

    public void printFinalResults(List<Player> playerList) {
        System.out.print("최종 우승자 : ");
        StringBuilder result = new StringBuilder();
        if (playerList.size() == 1) {
            result = new StringBuilder(playerList.get(0).name);
        }

        if (playerList.size() > 1) {
            for (Player player : playerList) {
                result.append(player.name).append(", ");
            }
            result = new StringBuilder(result.substring(0, result.length() - 2));
        }

        System.out.print(result);
    }
}
