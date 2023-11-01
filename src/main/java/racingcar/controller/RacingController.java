package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.TryCountValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    private  Cars cars;
    private int tryCount;

    public void start() {
        set();
        race();

    }

    private void race() {
        int nowTryCount = 0;
        OutputView.printPlayMessage();

        while (tryCount + 1 != nowTryCount++){
            cars.move();
            OutputView.printRoundResult(cars.getCars());
        }
    }

    private void set() {
        cars = new Cars(InputView.readCars());
        TryCountValidator validator = new TryCountValidator(InputView.readTryCount());
        tryCount = validator.tryCount;
    }
}
