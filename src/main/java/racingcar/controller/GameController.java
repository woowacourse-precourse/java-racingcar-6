package racingcar.controller;

import static racingcar.util.vaildator.carNameValidator.validateMinimumCarNameCount;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.CarList;
import racingcar.model.move.RandomMove;
import racingcar.util.number.NumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final RandomMove randomMove;
    private final CarList carList = new CarList();

    public GameController(InputView inputView, OutputView outputView, RandomMove randomMove) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.randomMove = randomMove;
    }

    public void start() {
        setCarList();
        moveCars();
    }

    private boolean isMove() {
        return randomMove.isMove(NumberGenerator.getRandomNumber());
    }

    private void setCarList() {
        List<String> carNames = inputView.inputCarNames();
        carNames.stream()
                .map(Car::new)
                .forEach(carList::addCar);
        validateMinimumCarNameCount(carNames);
    }

    private void moveCars() {
        int inputTry = inputView.inputTryCount();
        outputView.printResultMessage();
        for (int i = 0; i < inputTry; i++) {
            carList.carList().forEach(car -> car.move(isMove()));
            outputView.printCarResult(carList.carList());
        }
        outputView.printWinners(carList.getWinners());
    }

}
