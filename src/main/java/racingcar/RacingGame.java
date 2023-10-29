package racingcar;

import racingcar.enums.GameStatus;

public class RacingGame {

    private GameStatus status;

    public RacingGame(GameStatus status) {
        this.status = status;
    }

    public GameStatus getStatus() {
        return status;
    }

    public void setStatus(GameStatus status) {
        this.status = status;
    }

    public void start(int moveCount) {
        System.out.println("게임 시작");
    }
}
