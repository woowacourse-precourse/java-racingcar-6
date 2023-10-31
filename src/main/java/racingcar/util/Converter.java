package racingcar.util;

import java.util.Arrays;
import java.util.List;

import static racingcar.enums.ConverterConstant.DELIMITER;

public class Converter {
    public static List<String> getCarNames(String inputNames) {
        return Arrays.asList(inputNames.split(DELIMITER.getValue()));
    }
}
