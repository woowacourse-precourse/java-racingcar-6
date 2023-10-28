package racingcar.util.channel;

import camp.nextstep.edu.missionutils.Console;

public class ReaderForTrial extends Reader {

    private static final String REGEX_CHECK_AVAILABLE = "^[1-9][0-9]*$";
    private static final String REGEX_CHECK_NUMERIC = "[^0-9]";

    public ReaderForTrial() {
        super();
    }

    @Override
    public String read() {
        String trialInput = Console.readLine().trim();
        validateBlank(trialInput);
        validateNumeric(trialInput);
        validateAvailable(trialInput);
        return trialInput;
    }
    private void validateNumeric(String input) {
        if (input.matches(REGEX_CHECK_NUMERIC)) {
            throw new IllegalArgumentException();
        }
    }

    private void validateAvailable(String input) {
        if (!input.matches(REGEX_CHECK_AVAILABLE)) {
            throw new IllegalArgumentException();
        }
    }
}
