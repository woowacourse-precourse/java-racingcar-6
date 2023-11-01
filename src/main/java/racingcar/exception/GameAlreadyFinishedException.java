package racingcar.exception;

import static racingcar.exception.ExceptionConstant.GAME_ALREADY_FINISHED;

public class GameAlreadyFinishedException extends IllegalArgumentException{
    public GameAlreadyFinishedException() {
        super(GAME_ALREADY_FINISHED);
    }
}
