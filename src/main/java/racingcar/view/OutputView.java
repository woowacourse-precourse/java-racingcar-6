package racingcar.view;

import java.util.HashMap;

public class OutputView {
    public void printResultText() {
        System.out.println("실행 결과");
    }

    public void printExecutionResult(HashMap<String, Integer> cars) {
        cars.forEach((name, score) -> System.out.println(name + " : " + "-".repeat(score)));
    }
}
