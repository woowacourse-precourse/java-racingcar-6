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

    private static boolean isOverCarsCount(int number) {
        return number > GameConfig.MAX_CAR_COUNT.getValue();
    }
}
