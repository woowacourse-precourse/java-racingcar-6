package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class PromptHandler {
    public static void promptOutput(String message) {
        System.out.println(message);
    }

    public static void promptOutputWinner(List<String> winner) {
        System.out.println(GameMessage.FINAL_WINNER.getMessage() + String.join(", ", winner));
    }

    public static String[] promptInputCarsName() {
        String input = Console.readLine();

        return input.split(",");
    }

    public static int promptInputRoundCount() {
        String input = Console.readLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }
}
