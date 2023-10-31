package racingcar;

import java.util.List;

public class MainController {

    private final InputController inputController = new InputController();
    private Game game;

    public void initGame() {
        List<String> carNames = inputController.getCarNames();
        game = new Game(carNames);
    }
}