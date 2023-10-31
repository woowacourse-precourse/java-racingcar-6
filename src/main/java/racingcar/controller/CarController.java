package racingcar.controller;

import racingcar.domain.CarGame;
import racingcar.util.ValidInput;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class CarController {

    public void run() {
        String carNames = inputCarNames();
        int gameCount = inputGameCount();
        CarGame carGame = new CarGame(carNames);

        OutputView.printResult();
        playMovingCar(carGame, gameCount);

        OutputView.printWinner(carGame.findWinner());
    }

    private String inputCarNames() {
        String carNames = InputView.inputCarNames();
        ValidInput.validCarNameLength(carNames);
        ValidInput.validDistinctCarName(carNames);
        return carNames;
    }

    private int inputGameCount() {
        String gameCountStr = InputView.inputRacingCount();
        ValidInput.validOnlyNumber(gameCountStr);
        return Integer.parseInt(gameCountStr);
    }

    private void playMovingCar(CarGame carGame, int gameCount) {
        for (int i = 0; i < gameCount; i++) {
            carGame.movePosition();
            OutputView.printPosition(carGame.getCars());
        }
    }
}
