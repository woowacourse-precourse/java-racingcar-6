package racingcar.controller;

import racingcar.domain.car.CarMovement;
import racingcar.domain.car.Cars;
import racingcar.domain.car.carcomponent.carmove.CarMoveReader;
import racingcar.domain.util.Generator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void makeCarMove() {
        Cars cars = Generator.generaterCars(inputView.inputCarNames());
        CarMoveReader totalNumberToMove = Generator.generateCarMoveReader(inputView.inputAttemptTimes());

        CarMovement carMovementReader = new CarMovement(cars, totalNumberToMove);
        outputView.printResult();

        while (carMovementReader.isMovable()) {
            String moveResult = carMovementReader.moveCarsAndGetResult(Generator.randomCarMoveGenerator());
            outputView.printMoveResult(moveResult);
        }
        outputView.printWinCars(carMovementReader.getWinner());
    }
}
