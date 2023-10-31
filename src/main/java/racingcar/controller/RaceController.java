package racingcar.controller;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.CarNames;
import racingcar.domain.Cars;
import racingcar.util.NumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {
    private final InputView inputView;
    private final OutputView outputView;

    public RaceController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        final CarNames carNames = inputView.askCarNames();
        final Cars cars = createCars(carNames);

        int moveCount = inputView.askMoveCount();

        outputView.showExecutionResultMessage();
        repeatMoveCars(moveCount, cars);

        final List<Car> winners = cars.findWinners();

        outputView.showWinners(winners);
    }

    public void repeatMoveCars(int moveCount, Cars cars) {
        while (moveCount-- > 0) {
            cars.tryMoveCars();
            System.out.println();
        }
    }

    public Cars createCars(CarNames carNames) {
        final List<Car> cars = carNames.getCarNames().stream()
                .map(carName -> new Car(carName.trim()))
                .collect(Collectors.toList());

        return new Cars(cars);
    }
}
