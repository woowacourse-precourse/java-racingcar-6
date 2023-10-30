package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.util.InputValidator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    private static final String INVALID_CAR_NAME_LENGTH_MESSAGE = "자동차 이름은 1자 이상, 5자 이하만 가능합니다.";
    private static final String CAR_NAMES_DELIMITER = ",";
    private static final int SPLIT_LIMIT_NUMBER = -1;
    private static final String INVALID_GAME_COUNT_INPUT_MESSAGE = "게임 횟수는 숫자만 입력 가능합니다.";

    public List<String> readCarNamesInput() {
        String input = Console.readLine().trim();
        List<String> carNames = splitWordsByDelimiter(input, CAR_NAMES_DELIMITER);
        validateCarNames(carNames);
        return carNames;
    }

    public int readUserGameCountInput() {
        String input = Console.readLine().trim();
        if(InputValidator.isNumeric(input)) {
            return Integer.parseInt(input);
        }

        throw new IllegalArgumentException(INVALID_GAME_COUNT_INPUT_MESSAGE);
    }

    private List<String> splitWordsByDelimiter(String input, String delimiter) {
        return Arrays.stream(input.split(delimiter, SPLIT_LIMIT_NUMBER))
                .map(String::strip)
                .collect(Collectors.toList());
    }

    private void validateCarNames(List<String> carNames) {
        carNames.forEach(InputView::validateCarName);
    }

    private static void validateCarName(String carName) {
        if(!InputValidator.isValidCarNameLength(carName)) {
            throw new IllegalArgumentException(INVALID_CAR_NAME_LENGTH_MESSAGE);
        }
    }
}
