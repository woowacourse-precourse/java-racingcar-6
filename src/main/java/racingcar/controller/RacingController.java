package racingcar.controller;

import racingcar.model.Cars;
import racingcar.model.TryCount;
import racingcar.util.Converter;
import racingcar.util.NumberGenerator;
import racingcar.util.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

    private final InputView inputView;
    private final OutputView outputView;

    public RacingController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        Cars cars = getCars();
        TryCount tryCount = getTryCount();
        NumberGenerator numberGenerator = new RandomNumberGenerator();
        outputView.printResultMessage();
        runMultipleRaces(cars, tryCount, numberGenerator);
        outputView.printWinners(cars.getWinnerNames());
    }

    private Cars getCars() {
        outputView.printCarNamesInputMessage();
        String carNames = inputView.readInput();
        return Cars.from(Converter.convertCommaSeparatedStringToList(carNames));
    }

    private TryCount getTryCount() {
        outputView.printTryCountInputMessage();
        String count = inputView.readInput();
        return TryCount.from(count);
    }

    private void runMultipleRaces(final Cars cars, final TryCount tryCount, final NumberGenerator numberGenerator) {
        while (!tryCount.isEnd()) {
            race(cars, numberGenerator);
            tryCount.decrease();
        }
    }

    private void race(final Cars cars, final NumberGenerator numberGenerator) {
        cars.moveAll(numberGenerator);
        outputView.printResult(cars.getRacingStatuses());
    }
}
