package racingcar.game;

import java.util.List;
import racingcar.circuit.Circuit;
import racingcar.domain.car.RacingCar;
import racingcar.domain.result.RacingGameStatistics;
import racingcar.domain.trial.Trial;
import racingcar.domain.winner.Winners;
import racingcar.game.validate.BlankTrialValidator;
import racingcar.game.validate.EmptyCarNamesValidator;
import racingcar.game.validate.IntegerTrialValidator;
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
            circuit.moveRacingCars();
            RacingGameStatistics statistics = tryRacingGame();
            trial.useTrialCount();
            selectWinner(trial, statistics);
        }
    }

    private RacingGameStatistics tryRacingGame() {
        RacingGameStatistics statistics = circuit.getRacingGameStatistics();
        OutputView.showRacingResult(statistics);
        return statistics;
    }

    private void selectWinner(Trial trial, RacingGameStatistics results) {
        if (trial.isExhausted()) {
            Winners winners = results.getWinners();
            OutputView.showWinners(winners);
        }
    }

    private Trial prepareRacingGame() {
        setUpCars();
        return receiveTrial();
    }

    private void setUpCars() {
        List<String> carNames = receiveCarNames();
        carNames.stream().map(RacingCar::new).forEach(circuit::addRacingCar);
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
