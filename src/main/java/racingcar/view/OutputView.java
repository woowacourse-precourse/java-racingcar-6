package racingcar.view;

import java.util.ArrayList;

public class OutputView {

    public static void printStart() {
        System.out.println(Message.START_MESSAGE.getMessage());
    }

    public static void printAsk() {
        System.out.println(Message.ASK_ATTEMPT.getMessage());
    }

    public static void printResult() {
        System.out.println();
        System.out.println(Message.RESULT.getMessage());
    }

    public static void printStatus(ArrayList<String> resultList) {
        StringBuilder sb = new StringBuilder();

        for (String result : resultList) {
            sb.append(result).append('\n');
        }

        System.out.println(sb);
    }
}
