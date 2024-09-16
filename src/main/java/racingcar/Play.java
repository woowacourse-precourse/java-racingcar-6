package racingcar;

import java.util.LinkedHashMap;

import static racingcar.Resource.executionResultMessage;

public class Play {
    public LinkedHashMap<String, Integer> outputView(Start start) {
        CarMap carMap = new CarMap();
        LinkedHashMap<String, Integer> map = carMap.makeInitMap(start);
        ExecutionResult executionResult = new ExecutionResult();
        int attempts = start.getNumberAttempts();

        System.out.println(executionResultMessage);

        for (int i = 0; i < attempts; i++) {
            map = carMap.updateMap();
            executionResult.outputView(map);
        }

        return map;
    }
}
