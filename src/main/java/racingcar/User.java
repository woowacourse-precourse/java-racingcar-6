package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class User {
    static final String DELIMITER = ",";

    public static String input() {
        return Console.readLine();
    }

    public static List<String> splitInput(String input) {
        return Arrays.asList(input.split(DELIMITER));
    }

    public static int stringToInteger() throws IllegalArgumentException {
        try {
            return Integer.parseInt(input());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("문자가 아닌 숫자를 입력해 주세요.");
        }
    }
}
