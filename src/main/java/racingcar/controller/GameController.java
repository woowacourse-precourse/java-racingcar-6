package racingcar.controller;

import racingcar.domain.car.Cars;
import racingcar.domain.car.carcomponent.carmove.CarMoveReader;
import racingcar.util.Generator;
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
        Cars cars = Generator.generaterCars(inputView.inputCarNames());
        CarMoveReader carMoveReader = Generator.generateCarMoveReader(inputView.inputAttemptTimes());
        return new CarController(cars, carMoveReader);
    }

    private void moveCarsAndPrintResult(CarController carController) {
        while (carController.isMovable()) {
            String moveResult = carController.moveCarsAndGetResult(Generator.randomCarMoveGenerator());
            outputView.printMoveResult(moveResult);
        }
    }
}
