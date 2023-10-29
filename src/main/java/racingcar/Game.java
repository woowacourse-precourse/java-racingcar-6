package racingcar;

public class Game {
    private static int tries = 0;

    protected static void startGame() {
        gameInit();

        while (isLoopEnd()) {
            executeLoop();
        }

        gameEnd();
    }

}
