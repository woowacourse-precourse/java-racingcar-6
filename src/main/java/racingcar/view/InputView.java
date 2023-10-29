package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {

    private static final String INPUT_DELIMITER = ",";
    private static final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표("+ INPUT_DELIMITER + ") 기준으로 구분)";
    private static final String INPUT_RACE_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";

    public static List<String> inputStringsByDelimiter() {
        System.out.println(INPUT_CAR_NAME_MESSAGE);
        return Arrays.stream(Console.readLine().split(INPUT_DELIMITER))
                .toList();
    }

    public static int inputNumber() {
        System.out.println(INPUT_RACE_COUNT_MESSAGE);
        return convertStringToInt(Console.readLine());
    }

    private static int convertStringToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수만 입력할 수 있습니다.");
        }
    }
}
