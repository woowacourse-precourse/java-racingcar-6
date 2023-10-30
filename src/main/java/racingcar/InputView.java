package racingcar;

import static racingcar.Constant.PLAYER_NAMES_DELIMITER;
import static racingcar.Constant.PLAYER_NAMES_DELIMITER_NAME;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String PLAYER_NAMES_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 %s(%s) 기준으로 구분)";

    public static PlayerNamesDto InputPlayerNames() {
        System.out.printf(PLAYER_NAMES_INPUT_MESSAGE, PLAYER_NAMES_DELIMITER_NAME, PLAYER_NAMES_DELIMITER);
        printEmptyLine();
        String rawPlayerNames = Console.readLine();
        InputValidator.validatePlayerNames(rawPlayerNames);
        return InputConvertor.convertPlayerNames(rawPlayerNames);
    }

    private static void printEmptyLine() {
        System.out.println();
    }
}
