package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.MoveCount;
import racingcar.domain.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void runRace() {
        Cars cars = getCars();
        MoveCount moveCount = getMoveCount();

        outputView.printResultMsg();
        repeatGame(cars, moveCount);

    }

    private void repeatGame(Cars cars, MoveCount moveCount) {
        while (moveCount.tryMove()) {
            cars.move(new RandomNumberGenerator());
            outputView.printResult(cars.getResult());
        }
    }

    private Cars getCars() {
        List<String> names = inputView.getNames();
        return new Cars(names);
    }

    private MoveCount getMoveCount() {
        return inputView.getTryCount();
    }
}
