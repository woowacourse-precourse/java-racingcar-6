package racingcar;

import racingcar.domain.Game;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Game game = new Game(new InputView(), new OutputView());
        game.playGame();
    }
}
