package racingcar.printer;

import racingcar.message.Message;

public class Output {

    public static void gameResult(String result) {
        System.out.println(Message.RESULT.getMessage());
        System.out.println(result);
    }

    public static void winner(String winner) {
        System.out.println(Message.WINNER.getWinner(winner));
    }
}
