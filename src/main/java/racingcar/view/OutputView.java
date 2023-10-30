package racingcar.view;

import java.util.Map;

public class OutputView {
    public void currentScore(Map.Entry<String, Integer> entry) {
        System.out.print(entry.getKey() + " : ");
        for (int i = 0; i < entry.getValue(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
