package racingcar.view;

import java.util.List;
import java.util.Map;

public class OutputView {
    public static void printSystemMessage(SystemMessage systemMessage) {
        System.out.println(systemMessage.getMessage());
    }

    public static void printWinner(List<String> winner) {
        StringBuilder output = new StringBuilder("최종 우승자 : ");
        for (int i = 0; i < winner.size(); i++) {
            if (i > 1) {
                output.append(", ");
            }
            output.append(winner.get(i));
        }
        System.out.println(output);
    }

    public static void printPerMatchResult(Map<String, Integer> perMatchResult) {
        for (String name : perMatchResult.keySet()) {
            int distance = perMatchResult.get(name);
            System.out.println(name + " : " + drawDistance(distance));
        }
        System.out.println();
    }

    public static String drawDistance(int distance) {
//        String result = "";
//        for (int i = 0; i < distance; i++) {
//            result += "-";
//        }
//        return result;
        return "-".repeat(Math.max(0, distance));
    }

}
