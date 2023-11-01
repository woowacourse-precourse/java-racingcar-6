package racingcar;

import racingcar.domain.RacingGame;
import racingcar.service.RandomGenerator;
import racingcar.view.Input.InputParser;
import racingcar.view.Input.InputValidator;
import racingcar.view.Input.InputView;
import racingcar.view.Output.OutputView;

public class Application {
    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame(inputView(),new OutputView(), new RandomGenerator());

        racingGame.race();
    }
    private static InputView inputView() {
        return new InputView(
                new InputParser(), new InputValidator());
    }
}
