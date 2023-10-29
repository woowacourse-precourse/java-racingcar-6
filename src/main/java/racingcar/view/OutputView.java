package racingcar.view;

import java.util.List;
import racingcar.domain.RaceHistory;

public class OutputView {
    public void printRaceHistory(RaceHistory raceHistory) {
        List<String> carNames = raceHistory.getCarNames();
        List<List<Integer>> positionHistory = raceHistory.getPositionHistory();

        for (List<Integer> positions : positionHistory) {
            printRaceSnapshot(carNames, positions);
        }
    }

    private void printRaceSnapshot(List<String> carNames, List<Integer> positions) {
        for (int j = 0; j < positions.size(); j++) {
            System.out.println(carNames.get(j) + " : " + "-".repeat(positions.get(j)));
        }
        System.out.println();
    }

    private void printWinners(List<String> winners) {
        String winner = String.join(", ", winners);
        System.out.println("최종 우승자" + " : " + winner);
    }
}
