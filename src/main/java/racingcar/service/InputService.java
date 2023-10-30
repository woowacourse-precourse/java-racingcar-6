package racingcar.service;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static java.lang.Long.*;
import static racingcar.domain.StringConstant.*;
import static racingcar.validator.InputValidator.*;

public class InputService {
    public static String readInput() {
        return readLine();
    }


    public static String[] convertToStringArray(String line) {
        String[] carNames = line.split(CARS_SPLIT_DELIMITER);

        for (int i = 0; i < carNames.length; i++) {
            carNames[i] = carNames[i].trim();
            validateCarNameLength(carNames[i]);
        }

        return carNames;
    }


    public static Long convertToLong(String line) {
        validateTimesIsNumber(line);

        return parseLong(line);
    }
}
