package racingcar;

import racingcar.game.GameController;
import racingcar.game.GameService;
import racingcar.io.Input;
import racingcar.io.Output;

public class Application {
    public static void main(String[] args) {
        Input input = new Input();
        Output output = new Output();
        GameService gameService = new GameService();

        GameController controller = new GameController(input, output, gameService);
        controller.play();
    }
}
