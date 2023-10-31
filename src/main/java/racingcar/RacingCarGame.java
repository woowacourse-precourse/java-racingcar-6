package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCarGame {
    public void startGame() {
        InputView inputView = new InputView();
        User user = new User();

        inputView.printCarNameInputMsg();
        user.inputCarName();
        List<String> carNames = user.getCarNames();
        List<Car> cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());

        inputView.printTryCountInputMsg();
        user.inputTryCount();

        OutputView outputView = new OutputView();
        outputView.printGameResultMsg();

        int tryCount = user.getTryCount();
        while (tryCount > 0) {
            for (Car car : cars) {
                if (car.canMove()) {
                    car.move();
                }
            }
            outputView.printCarsPosition(cars);
            tryCount--;
        }

        Judge judge = new Judge(cars);
        List<Car> winners = judge.decideWinner();
        outputView.printWinnersName(winners);
    }
}
