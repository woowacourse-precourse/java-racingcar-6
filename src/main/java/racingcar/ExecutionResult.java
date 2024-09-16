package racingcar;

import java.util.LinkedHashMap;

public class ExecutionResult {
    public void outputView(LinkedHashMap<String, Integer> map) {
        for (String key : map.keySet()) {
            int value = map.get(key);

            System.out.print(key + " : ");

            for (int i = 0; i < value; i++) {
                System.out.print("-");
            }

            System.out.println();
        }

        System.out.println();
    }
}
