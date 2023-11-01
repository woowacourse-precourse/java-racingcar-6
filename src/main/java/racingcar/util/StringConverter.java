package racingcar.util;

import java.util.Arrays;
import java.util.List;
import racingcar.vo.CarName;
import racingcar.vo.TryNumber;

public class StringConverter {

    private static final String DELIMITER = ",";

    private StringConverter() {
    }

    public static List<CarName> stringToCarNameListByDelimiter(String carNames) {
        return Arrays.stream(carNames.split(DELIMITER))
                .map(name -> new CarName(name.trim()))
                .toList();
    }

    public static TryNumber stringToTryNumber(String tryNumber) {
        Integer number = Integer.valueOf(tryNumber);
        return new TryNumber(number);
    }
}
