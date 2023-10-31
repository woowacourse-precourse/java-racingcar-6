package racingcar;

import java.util.List;

public class GameManager {
    private final InputManager inputManager;
    private final OutputManager outputManager;

    public GameManager(InputManager inputManager, OutputManager outputManager) {
        this.inputManager = inputManager;
        this.outputManager = outputManager;
    }
    
    public void run() {
        // TODO: 게임 진행

        Game game = initializeGame();
    }

    private Game initializeGame() {
        List<Car> cars = initializeCars();
        int raceCount = initializeRaceCount();

        return new Game(cars, raceCount);
    }

}
