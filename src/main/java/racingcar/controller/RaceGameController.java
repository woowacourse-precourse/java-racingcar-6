package racingcar.controller;

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
        int inputLoop = getInputLoopCount();

        playGameMultipleTimes(racingCars, inputLoop);

        Result result = new Result(racingCars);
        announceWinners(result);
    }

    private RacingCars initializeGame() {
        outputView.printStartMessage();
        List<String> carNames = inputView.inputNamesStringToList();
        return new RacingCars(carNames);
    }

    private int getInputLoopCount() {
        outputView.printLoopSetMessage();
        return inputView.inputLoopStringToInt();
    }

    private void playGameMultipleTimes(RacingCars racingCars, int inputLoop) {
        outputView.printFirstResultMessage();
        for (int i = 0; i < inputLoop; i++) {
            playingGame(racingCars);
        }
    }

    private void playingGame(RacingCars racingCars) {
        racingCars.getAllCars().forEach(car -> {
            car.moveIfRandomSuccess();
            outputView.printRaceStatusMessage(car);
        });
        outputView.printSpaceMessage();
    }

    private void announceWinners(Result result) {
        outputView.printWinnerResultMessage(result.getWinnerNames());
    }
}
