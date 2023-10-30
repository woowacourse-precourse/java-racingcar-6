package racingcar.Validator;

import static racingcar.Message.RoundExceptionPrompt.RANGEPROMPT;
import static racingcar.Message.RoundExceptionPrompt.REALNUMBERPROMPT;
import static racingcar.Message.RoundExceptionPrompt.STRINGPROMPT;

import racingcar.Exception.GameException.RoundException;

public class RoundValidatorImpl implements RoundValidator {

    public void isNotString(String round) {
        if (round.matches(".*\\D.*")) {
            throw new RoundException(STRINGPROMPT.getMessage(round));
        }
    }

    public void isNotRealNumber(String round) {
        if (round.matches("\\d+\\.\\d+")) {
            throw new RoundException(REALNUMBERPROMPT.getMessage(round));
        }
    }

    public void isValidRange(String round) {
        if (Integer.parseInt(round) <= 0) {
            throw new RoundException(RANGEPROMPT.getMessage(round));
        }
    }
}
