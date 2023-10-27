package racingcar;

import racingcar.Car.Car;
import racingcar.Car.CarMover;
import racingcar.View.InputView;
import racingcar.View.OutputView;
import java.util.List;

public class Race {
    private List< Car > cars;

    public void init() {
        cars = InputView.promptCarNames();

    }

    public void play() {
        CarMover.moveCars(cars);
        OutputView.printCars(cars);
    }

}
