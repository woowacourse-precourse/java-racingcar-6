package racingcar.view;

import static java.util.stream.Collectors.toList;
import java.util.Arrays;
import java.util.List;

public class InputParser {

    private static final String INVALID_COUNT_INPUT = "시도할 횟수는 정수값만 입력될 수 있습니다.";
    private static final String INVALID_CAR_NAMES_INPUT = "입력의 마지막에 ,가 오면 안됩니다.";

    public List<String> parsingNames(String input) {
        if (input.endsWith(",")) {
            throw new IllegalArgumentException(INVALID_CAR_NAMES_INPUT);
        }
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .collect(toList());
    }

    public int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_COUNT_INPUT);
        }
    }

}
