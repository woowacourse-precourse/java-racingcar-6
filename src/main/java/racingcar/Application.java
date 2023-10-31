package racingcar;

import racingcar.controller.Game;
import racingcar.util.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        Game game = new Game(new InputView(), new OutputView(), new RandomNumberGenerator());
        game.play();
    }
}
