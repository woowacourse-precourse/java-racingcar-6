package racingcar.validation;

import racingcar.utils.ErrorMessage;

public class TryNumberValidation {

    public String input;

    public TryNumberValidation(String input) {
        validateBlank(input);
        validateIsNumber(input);
        this.input = input;
    }

    private void validateBlank(String input) {
        if (input.isBlank()){
            throw new IllegalArgumentException(ErrorMessage.EMPTY_INPUT.getMessage());
        }
    }

    private void validateIsNumber(String input){
        String regExp = "^[0-9]+$";
        if (!input.matches(regExp)){
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER.getMessage());
        }
    }
}
