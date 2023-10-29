package racingcar.Validator;

import static racingcar.Message.RoundExceptionPrompt.REALNUMBERPROMPT;
import static racingcar.Message.RoundExceptionPrompt.STRINGPROMPT;

import racingcar.Exception.GameException;
import racingcar.Exception.GameException.RoundException;

public class RoundValidator {

    public static void isNotString(String round) {
        if (!round.matches(".*[0-9].*")) {
            throw new RoundException(STRINGPROMPT.getMessage(round));
        }
    }

    public static void isNotRealNumber(String round) {
        if (round.contains(".")) {
            throw new RoundException(REALNUMBERPROMPT.getMessage(round));
        }
    }

    public static void isValidRange(String round) {
    }
}
