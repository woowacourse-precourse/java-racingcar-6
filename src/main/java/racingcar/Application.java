package racingcar;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();
        Race race = new Race();
        MainController mainController = new MainController(outputView, inputView, race);
        mainController.startGame();
    }
}
