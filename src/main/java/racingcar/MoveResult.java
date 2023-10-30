package racingcar;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import camp.nextstep.edu.missionutils.Randoms;

public class MoveResult {
    public void move(List<String> carNames, int attemptNumber) {
        System.out.println("실행 결과");

        Map<String, String> results = new HashMap<>();
        for (String name : carNames) {
            results.put(name, "");
        }

        for (int i = 0; i < attemptNumber; i++) {
            for (String name : carNames) {
                String currentResult = results.get(name);
                results.put(name, currentResult + generateResult());
            }
            printResults(results);
        }
    }

    private String generateResult() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            return "-";
        }
        return "";
    }

    private void printResults(Map<String, String> results) {
        for (Map.Entry<String, String> entry : results.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        System.out.println();
    }
}
