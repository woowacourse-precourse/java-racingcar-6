package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGame {
    public void run() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        Judgment judgment = new Judgment();
        Referee referee = new Referee();

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
            for (Car car : cars) {
                if (judgment.canMove(NumberGenerator.createRandomNumber())) {
                    car.move();
                }
                outputView.printCarInfo(car);
            }
            System.out.println();
        }

        List<Car> winners = referee.getWinner(cars);
        outputView.printWinner(winners);
    }
}
