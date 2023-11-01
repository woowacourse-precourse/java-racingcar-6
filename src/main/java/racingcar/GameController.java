package racingcar;

import java.util.stream.IntStream;
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
        Cars cars = getCars();
        int trialCount = getTrialCount();

        raceWith(cars, trialCount);
        outputView.printWinners(cars.getWinnerNames());
    }

    private Cars getCars() {
        return Cars.from(inputView.getNames());
    }

    private int getTrialCount() {
        return inputView.getTrialCount();
    }

    private void raceWith(Cars cars, int trialCount) {
        outputView.printRaceStartMessage();
        IntStream.range(0, trialCount)
                .forEach(count -> race(cars));
    }

    private void race(Cars cars) {
        cars.race(numberGenerator);
        outputView.printRoundResult(cars.toDto());
    }
}