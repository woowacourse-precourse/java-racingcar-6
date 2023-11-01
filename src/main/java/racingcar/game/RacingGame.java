package racingcar.game;

import java.util.List;
import racingcar.circuit.Circuit;
import racingcar.domain.car.RacingCar;
import racingcar.domain.statistics.RacingGameStatistics;
import racingcar.domain.trial.Trial;
import racingcar.domain.winner.Winners;
import racingcar.game.validate.BlankTrialValidator;
import racingcar.game.validate.EmptyCarNamesValidator;
import racingcar.game.validate.IntegerTrialValidator;
import racingcar.view.car.CarNamesInputView;
import racingcar.view.car.CarNamesOutputView;
import racingcar.view.statistics.RacingStatisticsView;
import racingcar.view.trial.TrialInputView;
import racingcar.view.trial.TrialOutputView;
import racingcar.view.winner.RacingWinnerView;

public class RacingGame {
    private final Circuit circuit;

    public RacingGame(Circuit circuit) {
        this.circuit = circuit;
    }

    public void play() {
        Trial trial = prepareRacingGame();
        process(trial);
    }

    private void process(Trial trial) {
        while (!trial.isExhausted()) {
            trial.useTrialCount();
            RacingGameStatistics statistics = runRace();
            selectFinalWinners(trial, statistics);
        }
    }

    private RacingGameStatistics runRace() {
        circuit.moveRacingCars();
        RacingGameStatistics statistics = circuit.getRacingGameStatistics();
        RacingStatisticsView.showRacingResult(statistics);
        return statistics;
    }

    private void selectFinalWinners(Trial trial, RacingGameStatistics statistics) {
        if (trial.isExhausted()) {
            Winners winners = statistics.getWinners();
            RacingWinnerView.showWinners(winners);
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
        CarNamesOutputView.inputCarNames();
        List<String> carNames = CarNamesInputView.getCarNames();
        EmptyCarNamesValidator.validate(carNames);
        return carNames;
    }

    private Trial receiveTrial() {
        TrialOutputView.inputTrial();
        String racingTrial = TrialInputView.getRacingTrial();
        BlankTrialValidator.validate(racingTrial);
        Integer trialCount = IntegerTrialValidator.validate(racingTrial);
        return new Trial(trialCount);
    }
}
