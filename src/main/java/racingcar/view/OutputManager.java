package racingcar.view;

import java.util.Map;

public class OutputManager {
    public void printCarStatus(Map<String, Integer> carStatus) {
        carStatus.forEach((key, value) -> {
            System.out.println(String.format("%s : %s", key, "-".repeat(value)));
        });
    }
}
