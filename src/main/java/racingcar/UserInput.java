package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class UserInput {
    public static String[] readCarNames() {
        String input = Console.readLine();
        String[] carNames = input.split(",");
        validateCarNames(carNames);
        return carNames;
    }

    private static void validateCarNames(String[] carNames) {
        if (carNames.length == 0) {
            throw new RacingGameException("자동차 이름을 입력해야 합니다.");
        }
    }

    public static int readNumberOfAttempts() {
        String input = Console.readLine();
        int numberOfAttempts = validateNumberOfAttempts(input);
        return numberOfAttempts;
    }

    private static int validateNumberOfAttempts(String input) {
        try {
            int number = Integer.parseInt(input);
            if (number < 1 || number > 9) {
                throw new RacingGameException("1~9 사이의 횟수를 입력해야 합니다.");
            }
            return number;
        } catch (NumberFormatException e) {
            throw new RacingGameException("올바른 숫자를 입력해야 합니다.");
        }
    }
}

