package racingcar.global.exception;

import camp.nextstep.edu.missionutils.Console;

public class RacingCarException extends IllegalArgumentException {
    private RacingCarException(ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
    }

    public static RacingCarException of(ErrorMessage errorMessage) {
        Console.close();
        return new RacingCarException(errorMessage);
    }
}
