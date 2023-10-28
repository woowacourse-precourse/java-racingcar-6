package racingcar.view.inputview;

import camp.nextstep.edu.missionutils.Console;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Pattern;

public class RegisterRoundInputView extends InputView<String> {
    private static final Pattern NUMBER_PATTERN = Pattern.compile("^[0-9]+$");
    @Override
    public String input(Map<String, Object> model) {
        String line = Console.readLine();
        validate(line);
        closeScanner();
        return line;
    }

    private void validate(String inputRound) {
        hasValidCharacters(inputRound);
        startsWithNonZero(inputRound);
    }

    private void startsWithNonZero(String inputRound) {
        if (Objects.equals(inputRound.charAt(0), '0')) {
            throw new IllegalArgumentException("0으로 시작하는 수를 입력했습니다");
        }
    }

    private void hasValidCharacters(String inputRound) {
        if (!NUMBER_PATTERN.matcher(inputRound).matches()) {
            throw new IllegalArgumentException("숫자를 입력해주세요");
        }
    }
}
