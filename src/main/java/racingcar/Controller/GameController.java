package racingcar.Controller;

import racingcar.View.RacingView;

import java.util.List;

public class GameController {
    public static void startGame(){
        RacingView racingView = new RacingView();

        racingView.UserInput();
        racingView.GameResult();
        racingView.GameWinner();
    }

}
