package racingcar;

import java.util.List;
import java.util.Map;

public class Output {

    public static void printStartMessage() {
        System.out.println(Message.START.getValue());
    }

    public static void printCountMessage() {
        System.out.println(Message.COUNT.getValue());
    }

    public static void printRoundStartMessage() {
        System.out.println(Message.ROUNDSTART.getValue());
    }

    public static void printWinners(List<String> winners) {
        System.out.println(Message.END.getValue() + String.join(", ", winners));
    }

    public static void printRoundResult(Map<String, Integer> scores) {
        for (String car : scores.keySet()) {
            System.out.println(car + " : " + "-".repeat(scores.get(car)));
        }
        System.out.println();
    }

}