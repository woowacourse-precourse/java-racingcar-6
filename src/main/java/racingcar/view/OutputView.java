package racingcar.view;

import static racingcar.constant.AllPunctuationMarks.*;
import static racingcar.constant.RaceIOMessage.RACE_FINISH;
import static racingcar.constant.RaceIOMessage.RACE_RESULT;
import static racingcar.constant.RaceIOMessage.RACE_START;
import static racingcar.constant.RaceIOMessage.RACE_WINNER;

import java.util.List;
import java.util.Map;

public class OutputView {

    public void printRaceStart() {
        System.out.println(RACE_START);
    }

    public void printRaceFinish() {
        System.out.println(RACE_FINISH);
    }

    public void printTotalResult() {
        System.out.println(RACE_RESULT);
    }

    public void printProgressOfAllCars(Map<String, Integer> carNameList) {
        for (String carName : carNameList.keySet()) {
            printProgressOfOne(carName, carNameList.get(carName));
        }
        System.out.println();
    }

    private void printProgressOfOne(String carName, int moves) {
        System.out.println(convertProgressToString(carName, moves));
    }

    public String convertProgressToString(String carName, int moves) {
        return carName + COLONS + PROGRESS.repeat(Math.max(0, moves));
    }

    public void printWinnerList(List<String> winnerName) {
        System.out.println(convertWinnersToString(winnerName));
    }

    public String convertWinnersToString(List<String> winnerName) {
        StringBuilder winner = new StringBuilder(RACE_WINNER + winnerName.get(0));
        for (int i = 1; i < winnerName.size(); i++) {
            winner.append(COMMA + SPACE);
            winner.append(winnerName.get(i));
        }
        return winner.toString();
    }
}