package racingcar.view;

import java.util.List;
import java.util.Map;

public class OutputView {

    public void printExecution() {
        System.out.println("실행 결과");
    }

    public void printResult(Map<String, Integer> position) {
        for (String name : position.keySet()) {
            System.out.println(name + " : " + "-".repeat(position.get(name)));
        }
    }

    public void printFinalWinner(List<String> winner) {
        System.out.println("최종 우승자 : " + formatted(winner));
    }

    private String formatted(List<String> winner) {
        return String.join(", ", winner);
    }
}
