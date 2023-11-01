package racingcar.view;

import static racingcar.Config.*;

public class OutputView {


    public void gameStart() {
        System.out.printf(GAME_START_MESSAGE);
    }

    public void roundInputMessage() {
        System.out.printf(Round_Input_MESSAGE);
    }

    public void ResultMessage() {
        System.out.printf(Result_MESSAGE);
    }

    public void RoundResult(String result) {
        System.out.println(result);
    }

    public void gameResult(String winnerList) {
        System.out.printf(Winner_MESSAGE + winnerList);
    }
}
