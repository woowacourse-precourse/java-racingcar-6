package racingcarv2.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Objects;
import java.util.regex.Pattern;

public class InputView {
    private static final int EMPTY_INPUT_LENGTH = 0;
    private static final Pattern NAME_PATTERN = Pattern.compile("^([a-aA-Z]+,?)+$");

    public static String inputCarNames() {
        String readLine = Console.readLine();
        validate(readLine);
        return readLine;
    }

    private static void validate(String readLine) {
        isNullOrEmpty(readLine);
        hasWrongPattern(readLine);
    }

    private static void isNullOrEmpty(String readLine) {
        if (Objects.isNull(readLine) || Objects.equals(readLine.length(), EMPTY_INPUT_LENGTH)) {
            throw new IllegalArgumentException("아무것도 입력하지 않았습니다");
        }
    }

    private static void hasWrongPattern(String readLine) {
        if (!NAME_PATTERN.matcher(readLine).matches()) {
            throw new IllegalArgumentException("형식에 맞지 않는 입력입니다");
        }
    }
}
