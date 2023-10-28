package racingcar.output;

import racingcar.input.InputMessage;

public class Output {
    private static void print(OutputMessage message) {
        System.out.println(message.getMessage());
    }

    public static void printResult() {
        print(OutputMessage.RESULT);
    }

    public static void printWinner() {
        print(OutputMessage.WINNER);
    }
}
