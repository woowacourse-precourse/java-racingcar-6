package racingcar.domain;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Logs {

    private Map<String,String> logs;

    public Logs(Map<String, Integer> carsMap) {

        this.logs = generateLogs(carsMap);
    }

    public Map<String, String> getLogs() {
        return logs;
    }

    private Map<String,String> generateLogs(Map<String, Integer> carsMap) {
        Map<String,String> initialLogs = new LinkedHashMap<>();
        Set<String> cars = carsMap.keySet();
        cars.stream().forEach(car -> initialLogs.put(car, ""));
        return initialLogs;
    }

    public void update(String car, int position) {
        if (position > 0) {
            logs.put(car,"-".repeat(position));
        }
        if (position <= 0) {
            logs.put(car,"");
        }
    }

}
