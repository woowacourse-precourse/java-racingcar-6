package racingcar;

import racingcar.domain.RacingGame;
import racingcar.service.RandomGenerator;
import racingcar.view.Input.InputParser;
import racingcar.view.Input.InputValidator;
import racingcar.view.Input.InputView;

public class Application {
    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame(new InputView(new InputParser(), new InputValidator()), new RandomGenerator());
        racingGame.goOrStop();
    }
}
