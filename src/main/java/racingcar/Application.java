package racingcar;

import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        OutputView.printCarNameMessage();
        Cars cars = new Cars(InputView.readCarNames());

        RacingGame racingGame = new RacingGame(cars.getCars());

        racingGame.run();
    }
}
