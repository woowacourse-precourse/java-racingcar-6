package racingcar.view.Input;

import static racingcar.util.FinalNumber.INVALID_NUMBER;
import static racingcar.util.FinalNumber.MIN_TRIAL_NUMBER;
import static racingcar.view.ExceptionMessage.ExceprionMessage.IS_NUBER_ONLY;
import static racingcar.view.ExceptionMessage.ExceprionMessage.IS_POSITIVE_ONLY;

public class InputValidator {
    private final String NUMBER_REGX = "^[0-9]+$";


    public void isNull(String input) {
        if (input.trim().length() == INVALID_NUMBER) {
            throw new IllegalArgumentException("");
        }
    }

    public void validateTrialNumber(String number) {
        isNumberOnly(number);
        isPositiveOnly(number);
    }

    public void isNumberOnly(String number) {
        if (!number.matches(NUMBER_REGX)) {
            throw new IllegalArgumentException(IS_NUBER_ONLY);
        }
    }
    public void isPositiveOnly(String number) {
        if (Integer.parseInt(number) < MIN_TRIAL_NUMBER) {
            throw new IllegalArgumentException(IS_POSITIVE_ONLY);
        }
    }
}
