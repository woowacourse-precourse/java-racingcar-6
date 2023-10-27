package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {

    private static final String START_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String BLANK_ERROR_MESSAGE = "자동차 이름은 공백값을 가질 수 없습니다.";
    private static final String BLANK = " ";
    private static final String DELIMITER = ",";

    private InputView() {
    }

    public static List<String> getCarNameList() {
        System.out.println(START_INPUT_MESSAGE);
        String input = Console.readLine();
        validateBlank(input);

        return Arrays.asList(input.split(DELIMITER));
    }

    private static void validateBlank(String input) {
        if (input.isBlank() || input.contains(BLANK)) {
            throw new IllegalArgumentException(BLANK_ERROR_MESSAGE);
        }
    }
}
