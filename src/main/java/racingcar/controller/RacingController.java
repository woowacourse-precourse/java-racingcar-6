package racingcar.controller;

import org.junit.platform.commons.function.Try;
import racingcar.domain.Car;
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
        OutputView.printPlayMessage();
        while (tryCount != tryCount++){
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
