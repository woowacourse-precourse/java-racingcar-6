package racingcar;

import java.util.HashMap;
import java.util.Map;

public class InputConvertor {

    public static Map<String, String> toMap(String inputCarNames) {
        Map<String, String> racingCars = new HashMap<>();
        String[] tempStr = inputCarNames.split(",");
        for (String str : tempStr) {
            if (racingCars.containsKey(str)) {
                Validator.isDuplicateNames();
            }
            racingCars.put(str, " ");
        }
        return racingCars;
    }

    public static int toInt(String inputNumber) {
        return Integer.parseInt(inputNumber);
    }
}
