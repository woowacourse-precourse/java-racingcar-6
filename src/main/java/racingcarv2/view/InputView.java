package racingcarv2.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.Objects;
import java.util.regex.Pattern;
import racingcarv2.exception.ErrorException;
import racingcarv2.model.Name;

public class InputView {
    private static final int EMPTY_INPUT_LENGTH = 0;
    public static final int FIRST_DIGIT = 0;
    private static final Pattern NAME_PATTERN = Pattern.compile("^([a-zA-Z]+,?)+$");
    private static final Pattern NUMBER_PATTERN = Pattern.compile("^[0-9]+$");
    public static final String WHITE_SPACE = " ";
    public static final String NONE = "";
    public static final char ZERO = '0';


    public static String inputCarNames() {
        String readLine = Console.readLine();
        Arrays.stream(readLine.split(Name.SEPARATOR_COMMA))
                .map(splitName -> splitName.replaceAll(WHITE_SPACE, NONE))
                        .forEach(name -> validateName(name));
        return readLine;
    }

    private static void validateName(String readLine) {
        isNullOrEmpty(readLine);
        hasWrongPattern(readLine);
    }

    private static void isNullOrEmpty(String readLine) {
        if (Objects.isNull(readLine) || Objects.equals(readLine.length(), EMPTY_INPUT_LENGTH)) {
            throw new IllegalArgumentException(ErrorException.NOTHING_INPUT.getDescription());
        }
    }

    private static void hasWrongPattern(String readLine) {
        if (!NAME_PATTERN.matcher(readLine).matches()) {
            throw new IllegalArgumentException(ErrorException.WRONG_FORMAT.getDescription());
        }
    }

    public static String inputRoundTotal() {
        String readLine = Console.readLine();
        validateNumber(readLine);
        return readLine;
    }

    private static void validateNumber(String readLine) {
        isNullOrEmpty(readLine);
        isNotNumber(readLine);
        startsWithZero(readLine);
    }

    private static void isNotNumber(String readLine) {
        if (!NUMBER_PATTERN.matcher(readLine).matches()) {
            throw new IllegalArgumentException(ErrorException.NOT_NUMBER.getDescription());
        }
    }

    private static void startsWithZero(String readLine) {
        if (Objects.equals(readLine.charAt(FIRST_DIGIT), ZERO)) {
            throw new IllegalArgumentException(ErrorException.START_WITH_ZERO.getDescription());
        }
    }
}
