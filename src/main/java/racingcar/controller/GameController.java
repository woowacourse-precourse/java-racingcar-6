package racingcar.controller;

import racingcar.domain.car.Cars;
import racingcar.domain.car.carmove.CarMoveReader;
import racingcar.util.RandomMoveGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void doGame() {
        CarController carController = getCarController();
        outputView.printResult();
        moveCarsAndPrintResult(carController);
        outputView.printWinCars(carController.getWinner());
    }

    private CarController getCarController() {
        Cars cars = inputView.inputCarNames();
        CarMoveReader carMoveReader = inputView.inputTotalMoveNumber();
        return new CarController(cars, carMoveReader);
    }

    private void moveCarsAndPrintResult(CarController carController) {
        while (carController.isMovable()) {
            String moveResult = carController.moveCarsAndGetResult(RandomMoveGenerator.randomCarMoveGenerator());
            outputView.printMoveResult(moveResult);
        }
    }
}
