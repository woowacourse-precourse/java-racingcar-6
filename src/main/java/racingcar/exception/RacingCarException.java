package racingcar.exception;

import racingcar.constants.ErrorMessages;

public class RacingCarException extends IllegalArgumentException{

    public RacingCarException(ErrorMessages errorMessages){
        super(errorMessages.getMessage());
    }

}
