package racingcar;

import racingcar.domain.GameManager;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameManager gm = new GameManager();
        gm.initGame();
        gm.startGame();
    }
}
