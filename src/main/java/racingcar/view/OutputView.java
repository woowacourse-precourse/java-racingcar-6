package racingcar.view;

import java.util.List;
import java.util.Map;

public class OutputView {
    public static void printSystemMessage(SystemMessage systemMessage) {
        System.out.println(systemMessage.getMessage());
    }

    public static void printMatchesResult(List<Map<String, Integer>> result) {
        System.out.println("\n실행 결과");
        
    }
}
