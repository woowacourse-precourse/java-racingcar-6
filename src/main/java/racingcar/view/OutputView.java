package racingcar.view;

import static racingcar.constant.AllPunctuationMarks.*;
import static racingcar.constant.RaceIOMessage.RACE_FINISH;
import static racingcar.constant.RaceIOMessage.RACE_RESULT;
import static racingcar.constant.RaceIOMessage.RACE_START;
import static racingcar.constant.RaceIOMessage.RACE_WINNER;

import java.util.List;
import java.util.Map;

public class OutputView { // 출력 관련 기능 수행

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

    // 한 라운드의 각 자동차별 전진 현황을 모두 출력
    public void printAllCarProgress(Map<String, Integer> carNameList) {
        for (String carName : carNameList.keySet()) {
            printOneCarProgress(carName, carNameList.get(carName));
        }
        System.out.println();
    }

    // 한 자동차의 전진 현황을 출력
    private void printOneCarProgress(String carName, int moveCounts) {
        System.out.println(convertProgressToString(carName, moveCounts));
    }

    // 한 자동차의 전진 횟수를 시각적으로 나타내는 문자열로 변환
    public String convertProgressToString(String carName, int moveCounts) {
        return carName + COLONS + PROGRESS.repeat(Math.max(NO_MOVES, moveCounts));
    }

    // 최종 우승자 출력
    public void printWinnerList(List<String> winnerName) {
        System.out.println(convertWinnersToString(winnerName));
    }

    // 최중 우승자를 나열하는 방식으로 출력하기 위해 문자열 형태로 변환
    public String convertWinnersToString(List<String> winnerName) {
        StringBuilder winner = new StringBuilder(RACE_WINNER + winnerName.get(START_INDEX));
        for (int i = START_INDEX + 1; i < winnerName.size(); i++) {
            winner.append(COMMA + SPACE);
            winner.append(winnerName.get(i));
        }
        return winner.toString();
    }
}