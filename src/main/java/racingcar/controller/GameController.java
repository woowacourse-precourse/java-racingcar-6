package racingcar.controller;

import java.util.List;
import racingcar.model.CarGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    private final CarGame car;

    public GameController(CarGame car) {
        this.car = car;
    }

    public void play() {
        playInit();
        playGame();
        endGame();
    }

    private void playInit() {
        car.setCars(InputView.carName());
        car.setPlayCount(InputView.playCount());
        OutputView.printGuide();
    }

    private void playGame() {
        int playCount = car.getPlayCount();

        while (playCount-- > 0) {
            car.moveOrStop();
            OutputView.printPlayResult(car.getCars());
        }
    }

    private void endGame() {
        List<String> result = car.getWinner();

        OutputView.printWinner(result);
    }
}
