package racingcar;

import java.util.LinkedHashMap;

public class ExecutionResult {
    public void valuePrint_print(LinkedHashMap<String, Integer> map) {
        int value;
        for (String key : map.keySet()) {
            System.out.print(key + " : ");
            value = map.get(key);
            for (int i = 0; i < value; i++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }
}
