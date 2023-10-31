package racingcar.View;

import java.util.ArrayList;

public class GameResultView {

    private final String WINNER_NOTICE_MSG = "최종 우승자 : ";

    public String generateWinnerNamesMsg(ArrayList<String> winnerList) {
        return String.join(", ", winnerList);
    }

    public void printWinner(ArrayList<String> winnerList) {
        String winnerCarNamesMsg = generateWinnerNamesMsg(winnerList);
        System.out.print(WINNER_NOTICE_MSG + winnerCarNamesMsg);
    }

}
