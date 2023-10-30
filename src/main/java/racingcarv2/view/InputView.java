package racingcarv2.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.Objects;
import java.util.regex.Pattern;

public class InputView {
    private static final int EMPTY_INPUT_LENGTH = 0;
    private static final Pattern NAME_PATTERN = Pattern.compile("^([a-zA-Z]+,?)+$");
    private static final Pattern NUMBER_PATTERN = Pattern.compile("^[0-9]+$");
    public static final int FIRST_DIGIT = 0;

    public static String inputCarNames() {
        String readLine = Console.readLine();
        Arrays.stream(readLine.split(","))
                .map(splitName -> splitName.replaceAll(" ", ""))
                        .forEach(name -> validateName(name));
        return readLine;
    }

    private static void validateName(String readLine) {
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

    public static String inputRoundTotal() {
        String readLine = Console.readLine();
        validateNumber(readLine);
        return readLine;
    }

    private static void validateNumber(String readLine) {
        isNotNumber(readLine);
        startsWithZero(readLine);
    }

    private static void isNotNumber(String readLine) {
        if (!NUMBER_PATTERN.matcher(readLine).matches()) {
            throw new IllegalArgumentException("숫자를 입력하지 않았습니다");
        }
    }

    private static void startsWithZero(String readLine) {
        if (Objects.equals(readLine.charAt(FIRST_DIGIT), '0')) {
            throw new IllegalArgumentException("0으로 시작하는 수를 입력했습니다");
        }
    }
}
