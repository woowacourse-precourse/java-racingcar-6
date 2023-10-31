package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {

    private static final String START_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String BLANK_ERROR_MESSAGE = "자동차 이름은 공백값을 가질 수 없습니다.";
    private static final String TRIAL_COUNT_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String NAN_ERROR_MESSAGE = "숫자만 입력 가능합니다.";
    private static final String OUT_OF_RANGE_ERROR_MESSAGE = "1이상의 자연수만 입력 가능합니다.";
    private static final String BLANK = " ";
    private static final String DELIMITER = ",";
    private static final int MIN_VALUE = 1;

    private InputView() {
    }

    public static List<String> getCarNameList() {
        System.out.println(START_INPUT_MESSAGE);
        String input = read();
        validateBlank(input);

        return Arrays.asList(input.split(DELIMITER));
    }

    public static int getTrialCount() {
        System.out.println(TRIAL_COUNT_INPUT_MESSAGE);
        String input = read();
        validateNan(input);
        validateRange(input);

        return Integer.parseInt(input);
    }

    private static String read() {
        return Console.readLine();
    }

    private static void validateBlank(String input) {
        if (input.isBlank() || input.contains(BLANK)) {
            throw new IllegalArgumentException(BLANK_ERROR_MESSAGE);
        }
    }

    private static void validateNan(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(NAN_ERROR_MESSAGE);
        }
    }

    private static void validateRange(String input) {
        boolean isOutOfRange = Integer.parseInt(input) < MIN_VALUE;
        if (isOutOfRange) {
            throw new IllegalArgumentException(OUT_OF_RANGE_ERROR_MESSAGE);
        }
    }
}
