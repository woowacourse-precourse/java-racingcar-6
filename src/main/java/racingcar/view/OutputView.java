package racingcar.view;

import static racingcar.constant.AllPunctuationMarks.*;
import static racingcar.constant.RaceIOMessage.RACE_FINISH;
import static racingcar.constant.RaceIOMessage.RACE_RESULT;
import static racingcar.constant.RaceIOMessage.RACE_START;
import static racingcar.constant.RaceIOMessage.RACE_WINNER;

import java.util.List;
import java.util.Map;

public class OutputView {

    private static final int NO_MOVES = 0;

    private static final int START_INDEX = 0;

    public void printRaceStart() {
        System.out.println(RACE_START);
    }

    public void printRaceFinish() {
        System.out.println(RACE_FINISH);
    }

    public void printTotalResult() {
        System.out.println(RACE_RESULT);
    }

    public void printAllCarProgress(Map<String, Integer> carNameList) {
        for (String carName : carNameList.keySet()) {
            printOneCarProgress(carName, carNameList.get(carName));
        }
        System.out.println();
    }

    private void printOneCarProgress(String carName, int moveCounts) {
        System.out.println(convertProgressToString(carName, moveCounts));
    }

    public String convertProgressToString(String carName, int moveCounts) {
        return carName + COLONS + PROGRESS.repeat(Math.max(NO_MOVES, moveCounts));
    }

    public void printWinnerList(List<String> winnerName) {
        System.out.println(convertWinnersToString(winnerName));
    }

    public String convertWinnersToString(List<String> winnerName) {
        StringBuilder winner = new StringBuilder(RACE_WINNER + winnerName.get(START_INDEX));
        for (int i = START_INDEX + 1; i < winnerName.size(); i++) {
            winner.append(COMMA + SPACE);
            winner.append(winnerName.get(i));
        }
        return winner.toString();
    }
}