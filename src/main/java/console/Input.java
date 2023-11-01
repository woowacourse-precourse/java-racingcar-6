package console;

import static console.Validator.*;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    private Input() {}

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

    private static int parseToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 자료형입니다.");
        }
    }

}
