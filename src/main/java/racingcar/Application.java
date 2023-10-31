package racingcar;

import racingcar.domain.Game;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();

        Game game = new Game(outputView, inputView);
        game.run();
    }
}
