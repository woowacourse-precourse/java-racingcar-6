package racingcar.view;

import static racingcar.global.constants.SymbolType.DELIMITER;

import camp.nextstep.edu.missionutils.Console;
import racingcar.global.exception.ErrorMessage;
import racingcar.global.exception.RaceException;

public final class InputView {

    public static String readInput() {
        String input = Console.readLine();
        validateBlankInput(input);
        return input;
    }

    public static String readCarNames() {
        String carNames = readInput();
        validateInvalidDelimiter(carNames);
        return carNames;
    }

    private static void validateBlankInput(String input) {
        if (input.isBlank()) {
            throw RaceException.of(ErrorMessage.BLANK_INPUT_ERROR);
        }
    }


}
