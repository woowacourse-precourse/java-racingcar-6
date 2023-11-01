package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.util.InputValidator;
import racingcar.util.Parser;

import java.util.List;

public class InputView {

    private static final String INVALID_CAR_NAME_LENGTH_MESSAGE = "자동차 이름은 1자 이상, 5자 이하만 가능합니다.";
    private static final String DUPLICATE_CAR_NAME_MESSAGE = "자동차 이름은 중복될 수 없습니다.";
    private static final String INVALID_GAME_COUNT_INPUT_MESSAGE = "게임 횟수는 숫자만 입력 가능합니다.";
    private static final String CAR_NAMES_DELIMITER = ",";

    public List<String> readCarNamesInput() {
        String input = readLineAndTrim();
        List<String> carNames = Parser.parseCarNames(input, CAR_NAMES_DELIMITER);

        if(!InputValidator.isValidAllCarNameLength(carNames)) {
            throw new IllegalArgumentException(INVALID_CAR_NAME_LENGTH_MESSAGE);
        }

        if(InputValidator.hasDuplicateCarName(carNames)) {
            throw new IllegalArgumentException(DUPLICATE_CAR_NAME_MESSAGE);
        }

        return carNames;
    }

    public int readUserGameCountInput() {
        String input = readLineAndTrim();
        if(InputValidator.isNumeric(input)) {
            return Integer.parseInt(input);
        }

        throw new IllegalArgumentException(INVALID_GAME_COUNT_INPUT_MESSAGE);
    }

    private static String readLineAndTrim() {
        return Console.readLine().trim();
    }
}
