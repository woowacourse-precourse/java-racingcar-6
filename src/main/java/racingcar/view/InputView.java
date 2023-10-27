package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {
    private static final String READ_CAR_NAMES_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String READ_ATTEMPT_COUNT_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String READ_ATTEMPT_COUNT_ERROR_MESSAGE = "숫자만 입력해 주세요";

    private List<String> convertCarNames(String input) {
        return Arrays.stream(input.split(",")).map(String::trim).toList();
    }

    public List<String> readCarNames() {
        System.out.println(READ_CAR_NAMES_INPUT_MESSAGE);
        String input = Console.readLine();
        return convertCarNames(input);
    }

    private int parseInt(String string) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(READ_ATTEMPT_COUNT_ERROR_MESSAGE);
        }
    }

    public int readAttemptCount() {
        System.out.println(READ_ATTEMPT_COUNT_INPUT_MESSAGE);
        String input = Console.readLine();
        return parseInt(input);
    }
}
