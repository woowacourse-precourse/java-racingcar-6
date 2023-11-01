package racingcar.view;

import java.util.List;
import java.util.Map;

public class OutputView {
    public static void printSystemMessage(SystemMessage systemMessage) {
        System.out.println(systemMessage.getMessage());
    }

    public static void printWinner(List<String> winner) {
        System.out.println("최종 우승자 : " + String.join(", ", winner));
    }

    public static void printPerMatchResult(Map<String, Integer> perMatchResult) {
        for (String name : perMatchResult.keySet()) {
            int distance = perMatchResult.get(name);
            System.out.println(name + " : " + drawDistance(distance));
        }
        System.out.println();
    }

    public static String drawDistance(int distance) {
        return "-".repeat(Math.max(0, distance));
    }

}
