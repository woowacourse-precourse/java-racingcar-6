package racingcar.util;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

import static racingcar.util.InputValidationUtils.*;

public class InputUtils {

    public static final String SPLITTER = ",";

    public static List<String> readCarNames() {
        return Arrays.stream(readExistLine().split(SPLITTER))
                .toList();
    }

    public static int readAttemptCount() {
        String input = readExistLine();
        validateCannotBeInt(input);
        return Integer.parseInt(input);
    }

    private static String readExistLine() throws IllegalArgumentException {
        String input = Console.readLine();
        validateHasInput(input);
        return input;
    }
}
