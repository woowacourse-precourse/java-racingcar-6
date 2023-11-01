package racingcar;

import racingcar.controller.CarGameController;
import racingcar.view.InputParser;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {

        OutputView outputView = new OutputView();
        InputParser inputParser = new InputParser();
        InputView inputView = new InputView(inputParser);
        CarGameController carGameController = new CarGameController(inputView,outputView);
        carGameController.runWholeGame();
    }
}
