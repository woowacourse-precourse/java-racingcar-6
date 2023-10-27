package racingcar.controller;

import racingcar.model.Cars;
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
        int tryCount = getTryCount();
        NumberGenerator numberGenerator = new RandomNumberGenerator();
        while (tryCount-- > 0) {
            play(cars, numberGenerator);
        }
    }

    private Cars getCars() {
        outputView.printInputMessage();
        String carNames = inputView.readInput();
        return Cars.createFromCarNames(Converter.convertCommaSeparatedStringToList(carNames));
    }

    private int getTryCount() {
        String count = inputView.readInput();
        return Converter.convertStringToPositiveInt(count);
    }

    private void play(final Cars cars, final NumberGenerator numberGenerator) {
        cars.moveAll(numberGenerator);
    }
}
