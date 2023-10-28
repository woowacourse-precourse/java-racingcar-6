package racingcar.view.inputview;

import camp.nextstep.edu.missionutils.Console;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Pattern;
import racingcar.exception.ErrorException;

public class RegisterCarNamesInputView implements InputView<String> {
    public static final Pattern CAR_NAME_PATTERN = Pattern.compile("^([a-zA-Z],?)+$");

    @Override
    public String input(Map<String, Object> model) {
        String replacedLine = Console.readLine().replaceAll(" ", "");
        isNullOrEmpty(replacedLine);
        hasValidCharacters(replacedLine);
        return replacedLine;
    }

    private void isNullOrEmpty(String s) {
        if (Objects.isNull(s) || Objects.equals(s.length(), 0)) {
            throw new IllegalArgumentException(ErrorException.NOTHING_INPUT.getErrorDescription());
        }
    }

    private void hasValidCharacters(String s) {
        if (!CAR_NAME_PATTERN.matcher(s).matches()) {
            throw new IllegalArgumentException(ErrorException.NOT_ENGLISH_NAME.getErrorDescription());
        }
    }
}
