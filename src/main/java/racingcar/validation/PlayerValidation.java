package racingcar.validation;

import racingcar.utils.ErrorMessage;

public class PlayerValidation {

    private static final int PLAYER_LENGTH = 5;
    public String input;

    public PlayerValidation(String input) {
        validateBlank(input);
        validateLength(input);
        this.input = input;
    }

    private void validateBlank(String input) {
        if (input.isBlank()){
            throw new IllegalArgumentException(ErrorMessage.EMPTY_INPUT.getMessage());
        }
    }

    private void validateLength(String input) {
        if (input.length() > PLAYER_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.LENGTH_OVER_5.getMessage());
        }
    }
}
