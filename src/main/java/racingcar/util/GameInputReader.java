package racingcar.util;

import camp.nextstep.edu.missionutils.Console;

import static racingcar.util.InputValidationUtils.validateCannotBeInt;
import static racingcar.util.InputValidationUtils.validateHasInput;

public class GameInputReader {

    public static String readExistLine() throws IllegalArgumentException {
        String input = Console.readLine();
        validateHasInput(input);
        return input;
    }

    public static int readInt() {
        String input = readExistLine();
        validateCannotBeInt(input);
        return Integer.parseInt(input);
    }
}
