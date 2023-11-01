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

    public void startGame() {

        List<Car> cars = createCars();

        inputTryCount();

        playRound(cars);

        announceWinners(cars);
    }

    private void announceWinners(List<Car> cars) {
        Judge judge = new Judge(cars);
        List<Car> winners = judge.decideWinners();
        outputView.printWinnersName(winners);
    }

    private void playRound(List<Car> cars) {
        outputView.printGameResultMsg();

        int tryCount = user.getTryCount();
        while (tryCount > 0) {
            moveCars(cars);
            outputView.printCarsPosition(cars);
            tryCount--;
        }
    }

    private void inputTryCount() {
        inputView.printTryCountInputMsg();
        user.inputTryCount();
    }

    private List<Car> createCars() {
        inputView.printCarNameInputMsg();
        user.inputCarName();

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
