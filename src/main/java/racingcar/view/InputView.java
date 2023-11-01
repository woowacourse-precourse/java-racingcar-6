package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import static racingcar.utils.Parser.*;

public class InputView {

    private static final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_TRY_COUNT = "시도할 회수는 몇회인가요?";

    public static List<String> inputCarNames() {
        System.out.println(INPUT_CAR_NAMES_MESSAGE);
        String input = Console.readLine();
        InputValidator.validateList(input);
        return parseStrings(input);
    }

    public static Integer inputTryCount() {
        System.out.println(INPUT_TRY_COUNT);
        String input = Console.readLine();
        InputValidator.validateIntegerType(input);
        return parseInteger(input);
    }
}
