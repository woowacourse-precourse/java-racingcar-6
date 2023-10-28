package racingcar.view;

import static racingcar.constant.AllPunctuationMarks.*;
import static racingcar.constant.RaceIOMessage.RACE_WINNER;

import java.util.List;

public class OutputView {
    public void printRoundResult(String carName, int moves) {
        System.out.println(makeResultToString(carName, moves));
    }
    private String makeResultToString(String carName, int moves) {
        return carName + COLONS + PROGRESS.repeat(Math.max(0, moves));
    }
    public void printWinnerList(List<String> winnerName) {
        StringBuilder winner = new StringBuilder(RACE_WINNER + winnerName.get(0));
        for (int i = 1; i < winnerName.size(); i++) {
            winner.append(COMMA+BLANK).append(winnerName.get(i));
        }
        System.out.println(winner);
    }
}