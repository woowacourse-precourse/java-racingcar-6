package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class PromptHandler {
    public static void promptOutput(String message) {
        System.out.println(message);
    }

    public static String[] promptInputCarsName() {
        String input = Console.readLine();
        String[] carsName = input.split(",");

        if (isOverCarsCount(carsName.length)) {
            throw new IllegalArgumentException("자동차의 갯수가 초과되었습니다.");
        }

        return carsName;
    }

    public static int promptInputRoundCount() {
        String input = Console.readLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }

    private static boolean isOverCarsCount(int number) {
        return number > GameConfig.MAX_CAR_COUNT.getValue();
    }
}
