package racingcar.service;

import static racingcar.constant.ValidateMessage.NOT_FOUND_CAR;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;
import racingcar.model.TryCount;
import racingcar.view.input.InputView;
import racingcar.view.output.OutputView;

public class RacingGameService {
    private final InputView inputView;
    private final OutputView outputView;

    public RacingGameService(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void playGame(List<Car> cars, TryCount tryCount) {
        outputView.printOutExecuteGame();
        for (int i = 0; i < tryCount.getTryCount(); i++) {
            moveCars(cars);
            outputView.printGameStep(cars);
        }
    }

    private void moveCars(List<Car> cars) {
        for (Car car : cars) {
            if (car.canMove()) {
                car.move();
            }
        }
    }

    public void findWinner(List<Car> cars) {
        Car maxPositionCar = getMaxMove(cars);
        List<String> winners = getWinners(cars, maxPositionCar);
        outputView.printOutWinner(winners);
    }

    private Car getMaxMove(List<Car> cars) {
        return cars.stream()
                .max(Car::compareTo)
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_CAR.message));
    }

    private List<String> getWinners(List<Car> cars, Car maxPositionCar) {
        return cars.stream()
                .filter(car -> car.isSamePosition(maxPositionCar))
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
