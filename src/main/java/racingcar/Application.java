package racingcar;

import racingcar.controller.GameProgress;

public class Application {
    public static void main(String[] args) {
        GameProgress gameProgress = new GameProgress();

        gameProgress.startGame();
        gameProgress.doGame();
        gameProgress.finishGame();
    }
}
