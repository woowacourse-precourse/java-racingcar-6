package racingcar.view;

public class OutputView {

    public static void printStart() {
        System.out.println(Message.START_MESSAGE.getMessage());
    }

    public static void printAsk() {
        System.out.println(Message.ASK_ATTEMPT.getMessage());
    }

    public static void printResult() {
        System.out.println(Message.RESULT.getMessage());
    }
}
