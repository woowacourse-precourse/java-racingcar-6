package racingcar;

import racingcar.domain.Cars;
import racingcar.util.NumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    private final NumberGenerator numberGenerator;
    private final InputView inputView;
    private final OutputView outputView;

    public GameController(InputView inputView, OutputView outputView, NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Cars cars = Cars.of(inputView.getNames());
        int trialCount = inputView.getTrialCount();

        raceCars(cars, trialCount);
        outputView.printWinners(cars.getWinnerNames());
    }

    private void raceCars(Cars cars, int trialCount) {
        outputView.printRaceStartMessage();
        for (int i = 0; i < trialCount; i++) {
            outputView.printRoundResult(cars.race(numberGenerator));
        }
    }
}
