package racingcar;

import racingcar.input.ConsoleInput;
import racingcar.input.Input;
import racingcar.output.ConsoleOutput;
import racingcar.output.Output;

public class Application {
    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Output output = new ConsoleOutput();

        Game game = new Game(input, output);
        game.play();
    }
}
