package racingcar.view;

import java.util.List;
import java.util.Map;
import racingcar.History;

public class Announcer {
    private final String INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)";
    private final String INPUT_TRY_COUNT = "시도할 회수는 몇회인가요?";
    private final String RESULT_COMMENT = "실행 결과";

    public void announceToInputCarName() {
        println(INPUT_CAR_NAME);
    }

    public void announceToInputTryCount() {
        println(INPUT_TRY_COUNT);
    }

    public void announceRaceHistories(List<History> historyList) {
        println();
        println(RESULT_COMMENT);

        for (History history : historyList) {
            announceRaceHistory(history);
        }
    }

    private void announceRaceHistory(History history) {
        Map<String, Integer> nameAndPosition = history.nameAndPosition();
        for (String name : nameAndPosition.keySet()) {
            println(name + " : " + "-".repeat(nameAndPosition.get(name)));
        }

        println();
    }

    public void announceWinner(List<String> winnerList) {
        String winner = String.join(", ", winnerList);
        println("최종 우승자 : " + winner);
    }

    private void println(String message) {
        System.out.println(message);
    }

    private void println() {
        System.out.println("");
    }
}
