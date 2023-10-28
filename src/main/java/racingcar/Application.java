package racingcar;

import racingcar.input.ConsoleInput;
import racingcar.output.ConsoleOutput;

public class Application {
    public static void main(String[] args) {
        Game game = new Game(new ConsoleInput(), new ConsoleOutput());
        game.play();
    }
}
