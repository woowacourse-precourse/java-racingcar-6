package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {

    private static final String PRINT_READ_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String PRINT_READ_TRY_NUMBER_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String CAR_NAME_DELIMITER = ",";

    private InputView() {
    }

    public List<String> readCarName() {
        System.out.println(PRINT_READ_CAR_NAME_MESSAGE);
        return convertCarName(getInput());
    }

    public static String readGameRound() {
        System.out.println(PRINT_READ_TRY_NUMBER_MESSAGE);
        return getInput();
    }

    private List<String> convertCarName(final String input) {
        return Arrays.stream(splitWithComma(input))
                .map(String::trim)
                .toList();
    }

    private static String[] splitWithComma(final String input) {
        return input.split(CAR_NAME_DELIMITER);
    }

    private static String getInput() {
        return Console.readLine();
    }
}
