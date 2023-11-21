package racingcar.service;

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
            for (Car car : cars) {
                move(car);
            }
            outputView.printGameStep(cars);
        }
    }

    private void move(Car car) {
        car.move();
    }

    public void findWinner(List<Car> cars) {
        int maxMove = getMaxMove(cars);
        List<String> winners = getWinners(cars, maxMove);
        outputView.printOutWinner(winners);
    }

    private int getMaxMove(List<Car> cars) {
        return cars.stream()
                .mapToInt(car -> car.getDistance().length())
                .max()
                .orElse(0);
    }

    private List<String> getWinners(List<Car> cars, int maxMove) {
        return cars.stream()
                .filter(car -> car.getDistance().length() == maxMove)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
