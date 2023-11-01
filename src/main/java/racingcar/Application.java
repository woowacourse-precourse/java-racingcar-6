package racingcar;

import racingcar.domain.Racing;
import racingcar.domain.cars;
import racingcar.io.InputView;
import racingcar.io.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView(new OutputView());

        cars cars = new cars(InputView.readCarNames());
        Racing racing = new Racing(inputView.readMoveTurnCount());
    }
}
