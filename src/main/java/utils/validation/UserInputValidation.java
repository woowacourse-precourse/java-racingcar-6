package utils.validation;

import utils.message.ErrorMessage;

public class UserInputValidation {
    public static Integer checkNumber(String carRound) {
        try {
            return Integer.parseInt(carRound);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.ROUND_CNT_NUMBER.getMessage());
        }
    }
}
