package racingcar.view.inputview;

import camp.nextstep.edu.missionutils.Console;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Pattern;
import racingcar.exception.ErrorException;

public class RegisterRoundInputView implements InputView<String> {
    private static final Pattern NUMBER_PATTERN = Pattern.compile("^[0-9]+$");
    private static final char ZERO = '0';

    private void validate(String inputRound) {
        hasValidCharacters(inputRound);
        startsWithNonZero(inputRound);
    }

    private void startsWithNonZero(String inputRound) {
        if (Objects.equals(inputRound.charAt(0), ZERO)) {
            throw new IllegalArgumentException(ErrorException.START_WITH_ZERO.getErrorDescription());
        }
    }

    private void hasValidCharacters(String inputRound) {
        if (!NUMBER_PATTERN.matcher(inputRound).matches()) {
            throw new IllegalArgumentException(ErrorException.NOT_NUMBER.getErrorDescription());
        }
    }

    @Override
    public String input(Map<String, Object> model) {
        String line = Console.readLine();
        validate(line);
        return line;
    }
}
