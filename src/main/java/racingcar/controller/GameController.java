package racingcar.controller;

import java.util.List;
import racingcar.model.CarGame;
import racingcar.model.Validation;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    private final CarGame car;
    private int playCount;

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
        setPlayCount(InputView.playCount());
        OutputView.printGuide();
    }

    private void playGame() {
        while (playCount-- > 0) {
            car.moveOrStop();
            OutputView.printPlayResult(car.getCars());
        }
    }

    private void endGame() {
        List<String> result = car.getWinner();

        OutputView.printWinner(result);
    }

    private void setPlayCount(String playCount) {
        Validation.isPositiveInt(playCount);
        this.playCount = Integer.parseInt(playCount);
    }
}
