package racingcar.game;

import java.util.List;
import racingcar.circuit.Circuit;
import racingcar.domain.car.Car;
import racingcar.domain.trial.Trial;
import racingcar.game.validate.BlankTrialValidator;
import racingcar.game.validate.EmptyCarNamesValidator;
import racingcar.game.validate.IntegerTrialValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGame {

    private final InputView inputView;
    private final OutputView outputView;
    private final Circuit circuit;

    public RacingGame(InputView inputView, OutputView outputView, Circuit circuit) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.circuit = circuit;
    }

    public void start() {
        Trial trial = prepareRacingGame();
        playRacingGame(trial);
    }

    private void playRacingGame(Trial trial) {
        while (!trial.isExhausted()) {
            circuit.tryRacingGame();
            trial.useTrialCount();
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
        outputView.inputCarsNames();
        List<String> carNames = inputView.getCarNames();
        EmptyCarNamesValidator.validate(carNames);
        return carNames;
    }

    private Trial receiveTrial() {
        outputView.inputTrial();
        String racingTrial = inputView.getRacingTrial();
        BlankTrialValidator.validate(racingTrial);
        return new Trial(IntegerTrialValidator.validate(racingTrial));
    }
}
