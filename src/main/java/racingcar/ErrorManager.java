package racingcar;

import racingcar.message.ConsoleMessage;
import racingcar.message.ErrorMessage;

public class ErrorManager {

    public void validateNameLength(String name){
        if(name.length() > 5){
            throw new IllegalArgumentException(ErrorMessage.UNDER_5_LENGTH.getMessage());
        }
    }

    public void validateNameNull(String name){
        if (name.isBlank() || name.length() == 0) {
            throw new IllegalArgumentException(ErrorMessage.NAME_HAS_BLANK.getMessage());
        }
    }

    public void validateTrialIsNumber(String trial){
        try {
            Integer.parseInt(trial);
        } catch (NumberFormatException e) {
            System.out.println(ErrorMessage.INPUT_NOT_NUMBER.getMessage());
        }
    }

    public void validateTrialZero(String trial){
        if(Integer.parseInt(trial) < 1){
            throw new IllegalArgumentException(ErrorMessage.INPUT_ZERO.getMessage());
        }
    }


}
