package racingcar.view;

import java.util.List;
import racingcar.domain.RaceHistory;

public class OutputView {
    public static final String NAME_POSITION_SEPARATOR = " : ";
    public static final String SKID_MARK = "-";
    public static final String WINNER = "최종 우승자";
    public static final String WINNER_DELIMITER = ", ";
    public static final String RACE_RESULT = "실행 결과";

    public void printRaceHistory(RaceHistory raceHistory) {
        System.out.println();
        System.out.println(RACE_RESULT);

        List<String> carNames = raceHistory.getCarNames();
        List<List<Integer>> positionHistory = raceHistory.getPositionHistory();

        for (List<Integer> positions : positionHistory) {
            printRaceSnapshot(carNames, positions);
        }
    }

    private void printRaceSnapshot(List<String> carNames, List<Integer> positions) {
        for (int j = 0; j < positions.size(); j++) {
            System.out.println(carNames.get(j) + NAME_POSITION_SEPARATOR + SKID_MARK.repeat(positions.get(j)));
        }
        System.out.println();
    }

    public void printWinners(List<String> winners) {
        String winner = String.join(WINNER_DELIMITER, winners);
        System.out.println(WINNER + NAME_POSITION_SEPARATOR + winner);
    }
}
