package racingcar.util;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import static racingcar.util.InputConvertUtils.*;
import static racingcar.util.InputValidationUtils.validateCannotBeInt;
import static racingcar.util.InputValidationUtils.validateHasInput;

public class GameReader {

    public static List<String> readCarNames() {
        return carNamesToList(readExistLine());
    }

    private static String readExistLine() throws IllegalArgumentException {
        String input = Console.readLine();
        validateHasInput(input);
        return input;
    }

    public static int readAttemptCount() {
        return readInt();
    }

    private static int readInt() {
        String input = readExistLine();
        validateCannotBeInt(input);
        return Integer.parseInt(input);
    }
}
