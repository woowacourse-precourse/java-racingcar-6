package racingcar.view;

import static racingcar.view.SystemMessage.TESTING;

import java.util.List;
import java.util.Map;

public class OutputView {
    public static void printSystemMessage(SystemMessage systemMessage) {
        System.out.println(systemMessage.getMessage());
    }

    public static void printWinner(List<Map<String, Integer>> allMatchesResult) {
        Map<String, Integer> finalResult = allMatchesResult.get(allMatchesResult.size() - 1);
    }

    public static void printAllMatchesResult(List<Map<String, Integer>> allMatchesResult) {
        printSystemMessage(TESTING);
        for (Map<String, Integer> perMatchResult : allMatchesResult) {
            printPerMatchResult(perMatchResult);
            System.out.println();
        }

    }

    private static void printPerMatchResult(Map<String, Integer> perMatchResult) {
        for (String name : perMatchResult.keySet()) {
            int distance = perMatchResult.get(name);
            System.out.println(name + " : " + drawDistance(distance));
        }
    }

    private static String drawDistance(int distance) {
//        String result = "";
//        for (int i = 0; i < distance; i++) {
//            result += "-";
//        }
//        return result;
        return "-".repeat(Math.max(0, distance));
    }

}
