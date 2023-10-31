package racingcar.view.input;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class MainInputView {
    private static final String CARNAME_SPLIT_DELIMETER = ",";
    private static final Pattern NUMBER_PATTERN = Pattern.compile("\\d+");

    private MainInputView() {
    }

    public static List<String> readCarNames() {
        Input input = Input.readLine();
        String trimmedInput = input.trimmed();

        return Arrays.asList(trimmedInput.split(CARNAME_SPLIT_DELIMETER));
    }

    public static int readPlayCount() {
        Input input = Input.readLine();
        String trimmedInput = input.trimmed();

        if (!NUMBER_PATTERN.matcher(trimmedInput).matches()) {
            throw new IllegalArgumentException("시도 횟수는 숫자만 입력 가능합니다.");
        }

        return Integer.parseInt(trimmedInput);
    }
}
