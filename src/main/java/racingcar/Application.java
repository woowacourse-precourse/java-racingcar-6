package racingcar;

import java.util.List;
import racingcar.controller.RacingGame;
import racingcar.model.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        OutputView.printAskCarNames();
        List<Car> cars = InputView.inputCarNames();

        OutputView.printAskRound();
        int round = InputView.inputRound();

        RacingGame racingGame = new RacingGame(cars, round);
        racingGame.startGame();
    }
}
