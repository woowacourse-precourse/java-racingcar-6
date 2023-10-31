package racingcar.exception;

import racingcar.constants.ErrorMessage;

public class RacingCarException extends IllegalArgumentException{

    public RacingCarException(ErrorMessage errorMessage){
        super(errorMessage.getMessage());
    }

}
