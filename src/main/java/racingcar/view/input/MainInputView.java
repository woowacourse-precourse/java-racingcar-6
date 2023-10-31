package racingcar.view.input;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class MainInputView {
    private static final String CARNAME_SPLIT_DELIMETER = ",";
    private static final Pattern NUMBER_PATTERN = Pattern.compile("\\d+");
    private static final String WHITESPACES_REGEX = "\\s+";
    private static final String BLANK_STRING = "";

    private MainInputView() {
    }

    public static List<String> readCarNames() {
        String input = readTrimmedLine();

        return Arrays.asList(input.split(CARNAME_SPLIT_DELIMETER));
    }

    public static int readPlayCount() {
        String input = readTrimmedLine();

        if (!NUMBER_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException("시도 횟수는 숫자만 입력 가능합니다.");
        }

        return Integer.parseInt(input);
    }

    private static String readTrimmedLine() {
        return trimmedString(Console.readLine());
    }

    private static String trimmedString(String rawString) {
        return rawString.replaceAll(WHITESPACES_REGEX, BLANK_STRING);
    }
}
