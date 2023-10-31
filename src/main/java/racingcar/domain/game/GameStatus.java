package racingcar.domain.game;

import static racingcar.domain.game.CarStatus.RUN;
import static racingcar.domain.game.CarStatus.STOP;

public class GameStatus {
    private static final int ATTEMPT = 1;


    private int attemptCount;
    private CarStatus carStatus;

    public GameStatus(int attemptCount) {
        this.attemptCount = attemptCount;
        this.carStatus = RUN;
    }

    public boolean isRunning() {
        this.attemptCount -= ATTEMPT;
        if(this.attemptCount < 0) {
            carStatus = STOP;
        }
        return carStatus.equals(RUN);
    }
}
