package racingcar;

import racingcar.controller.Game;
import racingcar.model.dto.GameInput;
import racingcar.view.InputView;

public class Application {
    public static void main(String[] args) {

        GameInput input = InputView.getInput();
        Game game = new Game(input);
        game.play();
    }
}
