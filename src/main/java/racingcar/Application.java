package racingcar;

import racingcar.input.ConsoleInput;
import racingcar.output.ConsoleOutput;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameManager gameManager = new GameManager(new ConsoleInput(), new ConsoleOutput());
        gameManager.run();
    }
}
