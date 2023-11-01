package racingcar;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        final InputView inputView = new InputView();
        final OutputView outputView = new OutputView();
        final CarRacingGame carRacingGame = new CarRacingGame(inputView, outputView);
        carRacingGame.run();
    }
}
