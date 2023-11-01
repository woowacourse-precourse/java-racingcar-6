package racingcar.view;

import java.util.List;
import java.util.Map;

public class OutputView {
    public void currentScore(Map.Entry<String, Integer> entry) {
        System.out.print(entry.getKey() + " : ");
        for (int i = 0; i < entry.getValue(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public void winner(List<String> names) {
        System.out.print("최종 우승자 : " + String.join(", ", names));
    }
}
