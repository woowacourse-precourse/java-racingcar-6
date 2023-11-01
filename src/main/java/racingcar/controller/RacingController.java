package racingcar.controller;

import java.util.List;
import java.util.stream.IntStream;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.view.InputView;
import racingcar.util.InputValidation;
import racingcar.view.OutputView;

public class RacingController {
    private final InputValidation inputValidation;

    public RacingController(InputValidation inputValidation) {
        this.inputValidation = inputValidation;
    }

    public void startGame() {
        InputView.greetingMessage();

        List<String> carNames = inputValidation.checkNameInputValid(InputView.inputCarsName());
        int round = inputValidation.checkRoundInputValid(InputView.inputRoundCount());

        Cars cars = initCars(carNames);
        List<Car> winners = doRound(cars, round);

        OutputView.printWinnerList(winners);
    }

    private Cars initCars(List<String> carNames) {
        Cars cars = new Cars();
        cars.initCars(carNames);

        OutputView.printResultConstant();
        return cars;
    }

    public List<Car> doRound(Cars cars, int round) {
        IntStream.range(0, round)
                .forEach(i -> OutputView.printCarResult(cars.doRound()));
        return cars.checkWinner();
    }

}
