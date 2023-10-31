package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputManager {
    public static String[] getCarNames() {
        System.out.print("경주할 자동차 이름을 입력하세요 (쉼표로 구분): ");
        String input = Console.readLine();
        validateCarNames(input);
        return input.split(",");
    }

    public static int getNumberOfAttempts() {
        System.out.print("시도할 회수를 입력하세요: ");
        int numberOfAttempts = parseNumberOfAttempts(Console.readLine());
        validateNumberOfAttempts(numberOfAttempts);
        return numberOfAttempts;
    }

    private static void validateCarNames(String input) {
        String[] carNames = input.split(",");
        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5글자 이하여야 합니다.");
            }
        }
    }

    private static int parseNumberOfAttempts(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("올바른 숫자를 입력하세요.");
        }
    }

    private static void validateNumberOfAttempts(int numberOfAttempts) {
        if (numberOfAttempts <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
    }
}
