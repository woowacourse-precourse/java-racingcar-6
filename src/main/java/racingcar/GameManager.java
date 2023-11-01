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
        try {
            Game game = initializeGame();
            GameResult gameResult = game.play();
            outputManager.printGameResult(gameResult);
        } catch (IllegalArgumentException ie) {
            throw ie;
        } catch (RuntimeException re) {
            throw new IllegalArgumentException(re.getMessage());
        }
    }

    private Game initializeGame() {
        List<Car> cars = initializeCars();
        int raceCount = initializeRaceCount();

        return new Game(cars, raceCount);
    }

    private List<Car> initializeCars() {
        outputManager.printCarNameRequestMessage();
        return inputManager.getCarNames()
                .stream()
                .map(Car::new)
                .toList();
    }

    private int initializeRaceCount() {
        outputManager.printRaceCountRequestMessage();
        return inputManager.getRaceCount();
    }
}
