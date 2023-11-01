package racingcar.domain.game;

import racingcar.enums.GameStatus;

public class Game {

    private final int tryNumber;
    private int currentTryNumber;
    private GameStatus gameStatus;

    public Game(int tryNumber) {
        this.tryNumber = tryNumber;
        gameStatus = GameStatus.PLAYING;
    }

    public boolean isPlay() {
        return gameStatus == GameStatus.PLAYING;
    }

    public void countPlayNumber() {
        currentTryNumber += 1;
        if(currentTryNumber == tryNumber) {
            gameStatus = GameStatus.END;
        }
    }
}
