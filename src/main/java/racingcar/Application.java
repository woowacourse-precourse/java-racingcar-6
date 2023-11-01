package racingcar;

import racingcar.game.Game;
import racingcar.io.InputAdaptor;
import racingcar.io.InputReceiver;
import racingcar.io.Parser;

/**
 * The entry of the program.
 */
public class Application {
    
    public static void main(String[] args) {
        Game game = new Game(new InputAdaptor(new InputReceiver(), new Parser()));
        game.inputCarNames();
        game.inputNumOfTries();
        game.execute();
    }
}
