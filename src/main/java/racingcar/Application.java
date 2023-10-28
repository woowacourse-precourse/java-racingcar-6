package racingcar;

import racingcar.core.GameManager;
import racingcar.core.Input;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Input input = new Input();
        GameManager gameManager = new GameManager(input);
    }
}
