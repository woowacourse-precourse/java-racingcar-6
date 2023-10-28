package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGame {
    private final InputView inputView;
    private final OutputView outputView;
    private final Judgment judgment;
    private final Referee referee;

    public RacingGame() {
        inputView = new InputView();
        outputView = new OutputView();
        judgment = new Judgment();
        referee = new Referee();
    }

    public void run() {
        outputView.printCarInputMessage();
        final List<String> carNames = inputView.askCarNames();

        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }

        outputView.printMoveCountInputMessage();
        final int tryCount = inputView.askMoveCount();

        outputView.printResultMessage();
        for (int i = 0; i < tryCount; i++) {
            moveCars(cars);
            for (Car car : cars) {
                outputView.printCarInfo(car);
            }

            outputView.printNewLine();
        }

        List<Car> winners = referee.getWinner(cars);
        outputView.printWinner(winners);
    }

    private void moveCars(List<Car> cars) {
        for (Car car : cars) {
            if (judgment.canMove(NumberGenerator.createRandomNumber())) {
                car.move();
            }
        }
    }
}
