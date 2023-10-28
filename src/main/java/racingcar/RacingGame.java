package racingcar;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Judgment;
import racingcar.domain.NumberGenerator;
import racingcar.domain.Referee;
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
        List<Car> cars = receiveCars();
        int tryCount = receiveTryCount();

        playCarRacing(cars, tryCount);
    }

    private List<Car> receiveCars() {
        outputView.printCarInputMessage();
        final List<String> carNames = inputView.askCarNames();

        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    private int receiveTryCount() {
        outputView.printTryCountInputMessage();
        int tryCount = inputView.askTryCount();
        return tryCount;
    }

    private void playCarRacing(List<Car> cars, int tryCount) {
        outputView.printResultMessage();
        for (int i = 0; i < tryCount; i++) {
            moveCars(cars);
            for (Car car : cars) {
                outputView.printCarInfo(car);
            }

            outputView.printNewLine();
        }
        processResult(cars);
    }

    private void moveCars(List<Car> cars) {
        for (Car car : cars) {
            if (judgment.canMove(NumberGenerator.createRandomNumber())) {
                car.move();
            }
        }
    }

    private void processResult(List<Car> cars) {
        List<Car> winners = referee.getWinner(cars);
        outputView.printWinner(winners);
    }
}
