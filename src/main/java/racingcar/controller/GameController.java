package racingcar.controller;

import racingcar.domain.car.Cars;
import racingcar.domain.car.carmove.CarMoveReader;
import racingcar.service.CarService;
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
        CarService carService = getCarController();
        outputView.printResult();
        moveCarsAndPrintResult(carService);
        outputView.printWinCars(carService.getWinner());
    }

    private CarService getCarController() {
        Cars cars = Cars.makeCars(inputView.inputCarNames());
        CarMoveReader carMoveReader = new CarMoveReader(inputView.inputTotalMoveNumber());
        return new CarService(cars, carMoveReader);
    }

    private void moveCarsAndPrintResult(CarService carService) {
        while (carService.isMovable()) {
            String moveResult = carService.moveCarsAndGetResult(RandomMoveGenerator.randomCarMoveGenerator());
            outputView.printMoveResult(moveResult);
        }
    }
}
