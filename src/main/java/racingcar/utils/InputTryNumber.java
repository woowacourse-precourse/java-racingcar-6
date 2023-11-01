package racingcar.utils;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

public class InputTryNumber {
    public static int getTryNumber() {
        System.out.println("시도할 회수는 몇회인가요?");
        String tryNumberInput = Console.readLine();
        validateTryNumberInput(tryNumberInput);
        return Integer.parseInt(tryNumberInput);
    }

    private static void validateTryNumberInput(String tryNumberInput) {
        if (!isNumeric(tryNumberInput)) {
            throw new IllegalArgumentException("숫자만 입력해주세요.");
        }
        int tryNumber = Integer.parseInt(tryNumberInput);
        if (tryNumber <= 0) {
            throw new IllegalArgumentException("게임이 종료됩니다.");
        }
    }

    private static boolean isNumeric(String str) {
        String pattern = "^[0-9]*$";
        return Pattern.matches(pattern, str);
    }
}
