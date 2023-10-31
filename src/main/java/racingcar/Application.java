package racingcar;

import racingcar.View.InputView;
import racingcar.View.OutputView;
import racingcar.controller.RacingGameManager;
import racingcar.model.Cars;

public class Application {
    public static void main(String[] args) {
        Cars cars = new Cars();
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        RacingGameManager racingGameManager = new RacingGameManager(cars, inputView, outputView);

        racingGameManager.gameStart();
    }
}
