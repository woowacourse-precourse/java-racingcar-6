package racingcar.view;

import static racingcar.system.SystemMessage.GAME_RESULT;
import static racingcar.system.SystemMessage.GAME_WINNER;

import java.util.List;
import racingcar.gamefield.DisplayBoard;

public class OutputView {

    public void responseRaceResultMessage() {
        System.out.println(GAME_RESULT.getMessage());
    }

    public void responseRacingResult(final DisplayBoard displayBoard) {
        System.out.println(displayBoard.displayCurrentCarPosition());
    }

    public void responseRaceWinner(final DisplayBoard displayBoard) {
        List<String> winnerList = displayBoard.getWinnerList();
        StringBuilder champion = new StringBuilder();
        champion.append(GAME_WINNER.getMessage());
        for (int count = 0; count < winnerList.size(); count++) {
            if (count > 0) {
                champion.append(", ");
            }
            champion.append(winnerList.get(count));
        }
        System.out.println(champion);
    }
}
