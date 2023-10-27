package racingcar.view;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {
    public void printResultText() {
        System.out.println("실행 결과");
    }

    public void printExecutionResult(HashMap<String, Integer> cars) {
        cars.forEach((name, score) -> System.out.println(name + " : " + "-".repeat(score)));
    }

    public void printFinalWinner(HashMap<String, Integer> cars) {
        int maxScore = cars.values().stream().mapToInt(Integer::intValue).max().orElse(0);

        List<String> winners = cars.entrySet().stream()
                .filter(entry -> entry.getValue() == maxScore)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        String winnerNames = String.join(", ", winners);
        System.out.print("최종 우승자 : " + winnerNames);
    }
}
