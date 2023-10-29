package racingcar.game;

import java.util.List;
import racingcar.circuit.Circuit;
import racingcar.domain.car.Car;
import racingcar.domain.result.RacingCarResult;
import racingcar.domain.trial.Trial;
import racingcar.game.validate.BlankTrialValidator;
import racingcar.game.validate.EmptyCarNamesValidator;
import racingcar.game.validate.IntegerTrialValidator;
import racingcar.utils.RacingGameWinnerCalculator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGame {
    private final Circuit circuit;

    public RacingGame(Circuit circuit) {
        this.circuit = circuit;
    }

    public void start() {
        Trial trial = prepareRacingGame();
        playRacingGame(trial);
    }

    private void playRacingGame(Trial trial) {
        while (!trial.isExhausted()) {
            circuit.tryRacingGame();
            List<RacingCarResult> results = circuit.summarizeRacingResult();
            OutputView.showRacingResult(results);
            trial.useTrialCount();
            selectWinner(trial, results);
        }
    }

    private void selectWinner(Trial trial, List<RacingCarResult> results) {
        if (trial.isExhausted()) {
            List<String> winners = RacingGameWinnerCalculator.getWinners(results);
            OutputView.showWinners(winners);
        }
    }

    private Trial prepareRacingGame() {
        setUpCars();
        return receiveTrial();
    }

    private void setUpCars() {
        List<String> carNames = receiveCarNames();
        carNames.stream().map(Car::new).forEach(circuit::addRacingCar);
    }

    private List<String> receiveCarNames() {
        OutputView.inputCarsNames();
        List<String> carNames = InputView.getCarNames();
        EmptyCarNamesValidator.validate(carNames);
        return carNames;
    }

    private Trial receiveTrial() {
        OutputView.inputTrial();
        String racingTrial = InputView.getRacingTrial();
        BlankTrialValidator.validate(racingTrial);
        return new Trial(IntegerTrialValidator.validate(racingTrial));
    }
}
