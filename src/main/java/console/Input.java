package console;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    private static final int NAME_LIMIT = 5;

    public static String[] carNamesInput() {
        String input = Console.readLine();
        String[] carNames = input.split(",");
        validateCarNames(carNames);
        return carNames;
    }

    public static int tryInput() {
        String tryInput = Console.readLine();
        int tryCount = parseToInt(tryInput);
        validateTry(tryCount);
        return tryCount;
    }

    private static void validateCarNames(String[] carNames) {
        for (String name : carNames) {
            if (name.length() > NAME_LIMIT) throw new IllegalArgumentException("이름은 5자 이하여야 합니다.");
        }
    }

    private static void validateTry(int tryCount) {
        if (tryCount <= 0 || tryCount >= 9) throw new IllegalArgumentException("입력값은 0에서 9 사이여야 합니다.");
    }

    private static int parseToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 자료형입니다.");
        }
    }

}
