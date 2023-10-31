package racingcar;

import racingcar.controller.GameController;
import racingcar.util.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameController gameController = new GameController(new InputView(),new OutputView(),new RandomNumberGenerator());
        gameController.playGame();
    }
}
