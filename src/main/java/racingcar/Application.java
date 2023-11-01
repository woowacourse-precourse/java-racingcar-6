package racingcar;

import java.util.List;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<Car> cars = InputView.inputCars();
        int rounds = InputView.inputRounds();

        RacingGame racingGame = new RacingGame(cars, rounds);
        racingGame.start();

        List<Car> winners = racingGame.findWinners();
        OutputView.printWinners(winners);

    }
}
