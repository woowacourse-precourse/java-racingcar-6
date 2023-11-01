package racingcar;

import racingcar.controller.RaceGameController;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        RaceGameController raceGameController = new RaceGameController(inputView, outputView);
        raceGameController.startGame();
    }
}
