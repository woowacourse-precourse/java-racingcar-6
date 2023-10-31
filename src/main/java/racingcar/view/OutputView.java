package racingcar.view;

import java.util.List;
import java.util.Map;

public class OutputView {
    public static void printSystemMessage(SystemMessage systemMessage) {
        System.out.println(systemMessage.getMessage());
    }

    public static void printAllMatchesResult(List<Map<String, Integer>> allMatchesResult) {
        System.out.println("\n실행 결과");
        for (int i = 0; i < allMatchesResult.size(); i++) {

            System.out.println();
        }

    }

    private static void printPerMatchResult(Map<String, Integer> perMatchResult) {
        for (String name : perMatchResult.keySet()) {
            
        }
    }
}
