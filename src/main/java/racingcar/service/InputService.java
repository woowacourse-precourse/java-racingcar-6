package racingcar.service;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static java.lang.Long.*;

// 고정 출력 문자열 상수 도메인으로
// validator 클래스 따로

public class InputService {
    public static String readInput() {
        return readLine();
    }


    public static String[] convertToStringArray(String line) {
        String[] carNames = line.split(",");

        for (String carName : carNames)
            validateCarNameLength(carName);

        return carNames;
    }

        private static void validateCarNameLength(String carName) {
            if (carName.length() > 5)
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }


    public static Long convertToLong(String line) {
        validateTurnNumber(line);

        return parseLong(line);
    }

        private static void validateTurnNumber(String line) {
            try {
                parseLong(line);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("횟수는 숫자로만 입력해주세요.");
            }
        }
}
