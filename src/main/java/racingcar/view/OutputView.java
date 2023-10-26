package racingcar.view;

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
}
