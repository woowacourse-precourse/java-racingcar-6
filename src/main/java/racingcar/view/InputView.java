package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {

    private static final String NAME_DELIMITER = ",";

    private static final String MESSAGE_INPUT_CAR_NAMES
            = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(" + NAME_DELIMITER + ") 기준으로 구분)";
    private static final String MESSAGE_INPUT_ROUNDS = "시도할 회수는 몇회인가요?";

    private InputView() {

    }

    public static List<String> inputCarNames() {
        System.out.println(MESSAGE_INPUT_CAR_NAMES);
        String inputNames = Console.readLine();

        return Arrays.stream(inputNames.split(NAME_DELIMITER))
                .map(String::trim)
                .toList();
    }

    public static int inputRounds() {
        try {
            System.out.println(MESSAGE_INPUT_ROUNDS);
            String inputRounds = Console.readLine();

            return Integer.parseInt(inputRounds);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException();
        }
    }
}
