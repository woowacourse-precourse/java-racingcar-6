package racingcar.utils;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

/**
 * InputUtils
 * <pre>
 * Describe here
 * </pre>
 *
 * @version 1.0,
 */
public class InputUtils {

    private InputUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static List<String> inputCarName() {
        String carNameListInput = Console.readLine();
        ValidUtils.validCarName(carNameListInput);
        return Arrays.stream(carNameListInput.split(",")).toList();
    }

    public static int inputTryCount() {
        String tryCountInput = Console.readLine();
        ValidUtils.validTryCount(tryCountInput);
        return Integer.parseInt(tryCountInput);
    }

}
