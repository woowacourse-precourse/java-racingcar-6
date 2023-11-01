package racingcar;

import java.util.LinkedHashMap;

public class Play {
    public LinkedHashMap<String, Integer> show(Start start) {
        CarMap carMap = new CarMap();
        LinkedHashMap<String, Integer> map = carMap.makeInitMap(start);
        ExecutionResult executionResult = new ExecutionResult();
        int attempts = start.getNumberAttempts();

        System.out.println("실행 결과");

        for (int i = 0; i < attempts; i++) {
            map = carMap.updateMap();
            executionResult.show(map);
        }
        return map;
    }
}
