package racingcar.controller;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;
import racingcar.model.Judge;
import racingcar.model.User;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarGame {
    private final InputView inputView = new InputView();
    private final User user = new User();
    private final OutputView outputView = new OutputView();

    public void readyGame() {
        inputView.printCarNameInputMsg();
        user.inputCarName();

        inputView.printTryCountInputMsg();
        user.inputTryCount();
    }

    public void startGame() {
        List<Car> cars = createCars();

        outputView.printGameResultMsg();
        playRacing(cars);

        announceWinners(cars);
    }

    private void announceWinners(List<Car> cars) {
        Judge judge = new Judge(cars);
        List<Car> winners = judge.decideWinners();
        outputView.printWinnersName(winners);
    }

    private void playRacing(List<Car> cars) {
        int tryCount = user.getTryCount();
        while (tryCount > 0) {
            moveCars(cars);
            outputView.printCarsPosition(cars);
            tryCount--;
        }
    }

    private List<Car> createCars() {
        List<String> carNames = user.getCarNames();
        return carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private void moveCars(List<Car> cars) {
        for (Car car : cars) {
            if (car.canMove()) {
                car.move();
            }
        }
    }
}
