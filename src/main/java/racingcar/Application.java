package racingcar;

import racingcar.io.InputManager;
import racingcar.io.OutputManager;
import racingcar.manager.GameManager;
import racingcar.utils.generator.NumberGenerator;
import racingcar.utils.generator.RandomNumberGenerator;
import racingcar.utils.provider.ConsoleInputProvider;
import racingcar.utils.provider.InputProvider;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputProvider inputProvider = new ConsoleInputProvider();
        NumberGenerator numberGenerator = new RandomNumberGenerator();

        OutputManager outputManager = new OutputManager();
        InputManager inputManager = new InputManager(outputManager, inputProvider);
        GameManager gameManager = new GameManager(inputManager, outputManager, numberGenerator);
        gameManager.startGame();
    }
}
