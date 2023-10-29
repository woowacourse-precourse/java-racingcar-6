package racingcar.service;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static java.lang.Long.*;
import static racingcar.domain.StringConstant.*;
import static racingcar.validator.InputValidator.*;

// 고정 출력 문자열 상수 도메인으로
// validator 클래스 따로

public class InputService {
    public static String readInput() {
        return readLine();
    }


    public static String[] convertToStringArray(String line) {
        String[] carNames = line.split(CARS_SPLIT_DELIMITER);

        for (String carName : carNames)
            validateCarNameLength(carName);

        return carNames;
    }


    public static Long convertToLong(String line) {
        validateTimesIsNumber(line);

        return parseLong(line);
    }
}
