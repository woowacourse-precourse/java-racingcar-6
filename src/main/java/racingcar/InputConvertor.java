package racingcar;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static racingcar.GameMessage.INPUT_DUPLICATE_EXCEPTION_MESSAGE;

public class InputConvertor {

    public static Map<String, String> toMap(String inputCarNames) {
        Map<String, String> carNamesMap = new HashMap<>();
        String[] tempStr = inputCarNames.split(",");
        for (String str : tempStr) {
            if (carNamesMap.containsKey(str)) {
                throw new IllegalArgumentException(INPUT_DUPLICATE_EXCEPTION_MESSAGE);
            }
            carNamesMap.put(str, "");
        }
        return carNamesMap;
    }

    public static int toInt(String inputNumber) {
        return Integer.parseInt(inputNumber);
    }
}
