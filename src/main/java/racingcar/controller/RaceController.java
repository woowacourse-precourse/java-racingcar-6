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

        System.out.println("\n실행 결과");
        repeatMoveCars(moveCount, cars.getCars());

        final List<Car> winners = cars.findWinners();

        outputView.showWinners(winners);
    }

    public void tryMoveCars(List<Car> cars) {
        for (Car car : cars) {
            int randomNumber = NumberGenerator.generateRandomNumber();

            car.moveForward(randomNumber);
            car.showMoveDistance();
        }
    }

    public void repeatMoveCars(int moveCount, final List<Car> cars) {
        while (moveCount-- > 0) {
            tryMoveCars(cars);
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
