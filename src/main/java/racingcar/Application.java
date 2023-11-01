package racingcar;

import camp.nextstep.edu.missionutils.Console;
import game.Game;
import game.GameInput;
import util.GamePrinter;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        GamePrinter.inputCarNames();
        String inputCarNames = Console.readLine();

        GamePrinter.inputCount();
        String inputCount = Console.readLine();

        GameInput gameInput = new GameInput();

        Game game = new Game(gameInput.inputCarNames(inputCarNames), gameInput.inputCount(inputCount));
        game.run();
    }
}
