package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class User {
    static final String DELIMITER = ",";

    public static List<String> inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        String input = input();
        isNull(input);
        return splitInput(input);
    }

    public static int inputMoveCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = input();
        isNull(input);
        try {
            int moveCount = stringToInteger(input);
            isZero(moveCount);
            return moveCount;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }

    public static String input() {
        return Console.readLine();
    }

    public static List<String> splitInput(String input) {
        return Arrays.asList(input.split(DELIMITER));
    }

    public static int stringToInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("문자가 아닌 숫자를 입력해 주세요.");
        }
    }

    public static void isNull(String input) {
        if (input == null) {
            throw new IllegalArgumentException("입력값이 없습니다.");
        }
    }

    public static void isZero(int moveCount) {
        if (moveCount == 0) {
            throw new IllegalArgumentException("입력회수는 0이 아닌 수를 입력해 주세요.");
        }
    }
}
