package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.RacingCars;
import racingcar.model.Result;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import java.util.List;

public class RaceGameController {
    private final InputView inputView;
    private final OutputView outputView;

    public RaceGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void startGame() {
        RacingCars racingCars = initializeGame();

        outputView.printLoopSetMessage();
        int inputLoop = inputView.inputLoopStringToInt();

        outputView.printFirstResultMessage();
        playGameMultipleTimes(racingCars, inputLoop);

        Result result = new Result(racingCars);
        outputView.printWinnerResultMessage(result.getWinnerNames());

    }

    private RacingCars initializeGame() {
        outputView.printStartMessage();
        List<String> carNames = inputView.inputNamesStringToList();
        return new RacingCars(carNames);
    }

    private void playGameMultipleTimes(RacingCars racingCars, int inputLoop) {
        for (int i = 0; i < inputLoop; i++) {
            playingGame(racingCars);
        }
    }

    private void playingGame(RacingCars racingCars) {
        for (Car car : racingCars.getAllCars()) {
            car.moveIfRandomSuccess();
            outputView.printRaceStatusMessage(car);
        }
        outputView.printSpaceMessage();
    }

}