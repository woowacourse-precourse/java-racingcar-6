package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.LinkedHashMap;

public class User {
    static final String DELIMITER = ",";

    public static String input() {
        return Console.readLine();
    }

    public static String[] splitInput(String input) {
        return input.split(DELIMITER);
    }

    public static int stringToInteger() throws IllegalArgumentException {
        try {
            return Integer.parseInt(input());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("문자가 아닌 숫자를 입력해 주세요.");
        }
    }
}
