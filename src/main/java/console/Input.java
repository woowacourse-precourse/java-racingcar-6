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
        try {
            int tryCount = Integer.parseInt(Console.readLine());
            validateTryInput(tryCount);
            return tryCount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 자료형입니다.");
        }
    }

    private static void validateCarNames(String[] carNames) {
        for (String name : carNames) {
            if (name.length() > NAME_LIMIT) throw new IllegalArgumentException("이름은 5자 이하여야 합니다.");
        }
    }

    private static void validateTryInput(int tryCount) {
        if (tryCount <= 0 || tryCount >= 9) throw new IllegalArgumentException("입력값은 0에서 9 사이여야 합니다.");
    }

}
