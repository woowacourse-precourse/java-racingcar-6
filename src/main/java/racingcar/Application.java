package racingcar;

import racingcar.controller.RacingController;
import racingcar.view.InputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        RacingController controller = new RacingController(inputView);
        controller.playRacingGame();
    }
}
