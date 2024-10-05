package racingcar.view;

import racingcar.domain.Car;

import java.util.HashMap;
import java.util.Map;

public class OutputView {

    public void printResult(Map<String, Integer> result) {
         for (String name : result.keySet()) {
            String count = "-".repeat(result.get(name));
            System.out.println(name + " : " + count);
        }
        System.out.println();
    }

    public void printWinner(String winner) {
        System.out.println("최종 우승자 : " + winner);
    }
}
