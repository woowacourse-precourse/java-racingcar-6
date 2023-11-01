package racingcar;

import racingcar.controller.GameController;
import racingcar.controller.util.PlayRule;
import racingcar.view.RacingView;

public class Application {


    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RacingView racingCar = new RacingView(); // view
        PlayRule rules = new PlayRule();
        GameController gameController = new GameController(racingCar, rules); // controller

        gameController.gameStart();
        gameController.gameOn();
    }
}
