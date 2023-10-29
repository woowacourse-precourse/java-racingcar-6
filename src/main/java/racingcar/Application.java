package racingcar;

import racingcar.view.GameStart;

public class Application {
    private static GameStart gameStart;

    public static void main(String[] args) {
        gameStart = new GameStart();
        gameStart.run();
    }
}
