package racingcar.view;

import java.util.ArrayList;
import java.util.HashMap;

public class OutputView {
    public void printResultText() {
        System.out.println("실행 결과");
    }

    public void printExecutionResult(HashMap<String, Integer> cars) {
        cars.forEach((name, score) -> System.out.println(name + " : " + "-".repeat(score)));
    }

    public void printFinalWinner(ArrayList<String> finalWinner) {
        String winners = String.join(", ", finalWinner);
        System.out.print("최종 우승자 : " + winners);
    }

    public void printEnterLine() {
        System.out.println();
    }
}
