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

    public void race() {
        String inputCarNames = inputView.inputCarNames();
        List<String> carNames = InputParser.parseCarNames(inputCarNames);
        InputValidator.validateCarNames(carNames);
        List<Car> cars = InputParser.convertNamesToCars(carNames);

        String inputAttemptCount = inputView.inputAttemptCount();
        InputValidator.validateAttemptCount(inputAttemptCount);
        int attemptCount = Integer.parseInt(inputAttemptCount);

        outputView.printGameStartMessage();

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
