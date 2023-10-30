package racingcar.controller;

import java.util.List;
import java.util.stream.IntStream;
import racingcar.domain.CarFactory;
import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    private Cars cars;
    private int roundNumber;

    public void execute() {
        set();
        start();
        announceWinners();
    }

    public void set() {
        outputView.printGameStart();
        List<String> names = inputView.insertCarName();
        cars = new Cars(CarFactory.createCars(names));
        outputView.printInsertCount();
        roundNumber = inputView.insertRoundNumber();
    }

    public void start() {
        outputView.printResultMessage();
        IntStream.range(0, roundNumber).forEach(i -> cars.play());
    }

    public void announceWinners() {
        cars.findWinners();
    }
}
