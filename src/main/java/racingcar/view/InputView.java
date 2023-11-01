package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {
    private static final String CAR_NAMES_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ROUND_COUNT_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String NOT_INTEGER_ERROR_MESSAGE = "숫자를 입력해주세요.";
    private static final String CAR_NAMES_INPUT_DELIMITER = ",";

    public List<String> inputCarNameStrings() {
        System.out.println(CAR_NAMES_INPUT_MESSAGE);
        String inputString = Console.readLine();
        String[] splitByDelimiter = inputString.split(CAR_NAMES_INPUT_DELIMITER);
        return Arrays.stream(splitByDelimiter).toList();
    }

    public int inputRoundCount() {
        System.out.println(ROUND_COUNT_INPUT_MESSAGE);
        String inputString = Console.readLine();
        validateInteger(inputString);
        return Integer.parseInt(inputString);
    }

    private void validateInteger(String inputString) {
        try {
            Integer.parseInt(inputString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_INTEGER_ERROR_MESSAGE);
        }
    }
}
