package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public final class InputDevice {
    private final static String DELIMITER = ",";

    private InputDevice() {
    }

    public static List<String> inputNamesWithCommaDelimiter() {
        String[] names = Console.readLine().split(DELIMITER, -1);
        return Arrays.asList(names);
    }

}
