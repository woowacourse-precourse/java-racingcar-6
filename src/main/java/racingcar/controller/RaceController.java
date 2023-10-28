package racingcar.controller;

import java.util.List;
import racingcar.manager.RaceManager;
import racingcar.model.Car;
import racingcar.model.RaceResult;
import racingcar.utils.InputParser;
import racingcar.utils.InputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {

    private final InputView inputView;
    private final OutputView outputView;
    private final RaceManager raceManager;

    public RaceController(InputView inputView, OutputView outputView, RaceManager raceManager) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.raceManager = raceManager;
    }

    public void startRace() {
        List<Car> cars = initializeCars();
        int attemptCount = initializeAttemptCount();
        outputView.printGameStartMessage();
        startRacingRounds(cars, attemptCount);

    }

    private List<Car> initializeCars(){
        List<String> carNames = inputView.inputCarNames();
        return InputParser.convertNamesToCars(carNames);
    }

    private int initializeAttemptCount(){
        return inputView.inputAttemptCount();
    }

    private void startRacingRounds(List<Car> cars, int attemptCount){
        RaceResult result = null;
        while (attemptCount-- > 0) {
            result = raceManager.playRound(cars);
            outputView.printRaceRoundResult(result.carsToList());
        }

        if(result != null) {
            outputView.printWinner(result);
        }
    }

}
