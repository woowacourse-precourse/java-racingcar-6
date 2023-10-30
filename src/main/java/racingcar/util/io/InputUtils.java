package racingcar.util.io;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.util.StringUtils;

public class InputUtils {

    public static String getCarsName() {
        return Console.readLine();
    }

    public static String getMoveNumber() {
        return Console.readLine();
    }

    public static void validateCarNameInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("입력 값이 없습니다.");
        }

        List<String> names = StringUtils.toCarNameList(input);
        for (String name : names) {
            validateCarNameLength(name);
        }
    }

    private static void validateCarNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름의 길이가 5자보다 깁니다.");
        }
    }

    public static void validateMoveNumberInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("입력 값이 없습니다.");
        } else if (!input.matches("-?\\d+")) {
            throw new IllegalArgumentException("입력 값이 숫자가 아닙니다.");
        } else if (Integer.parseInt(input) < 0) {
            throw new IllegalArgumentException("0 혹은 양수를 입력하세요");
        }
    }
}
