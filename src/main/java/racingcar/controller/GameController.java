package racingcar.controller;

import racingcar.model.CarGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final CarGame car = new CarGame();

    public void play() {
        car.setCarsName(inputView.carName());
        car.setPlayCount(inputView.playCount());
        outputView.printMessage();

        playGame();
    }

    private void playGame() {
        int playCount = car.getPlayCount();

        while (playCount-- > 0) {
            car.moveOrStop();
            outputView.printPlayResult(car.getCarsName());
        }
    }
}
