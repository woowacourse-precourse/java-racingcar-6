package racingcar;

import java.util.List;

public class GameManager {
    private InputManager inputManager;
    private OutputManager outputManager;

    public GameManager(InputManager inputManager, OutputManager outputManager) {
        this.inputManager = inputManager;
        this.outputManager = outputManager;
    }
}
