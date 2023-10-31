package racingcar.judge;

import java.util.Map;

public class Judge {
    public String calculateWinners(Map<String, String> driverMap) {
        int maxLaps = 0;
        StringBuilder winners = new StringBuilder();

        for (String driverName : driverMap.keySet()) {
            int laps = driverMap.get(driverName).length();
            if (laps > maxLaps) {
                maxLaps = laps;
                winners = new StringBuilder(driverName);
            } else if (laps == maxLaps) {
                winners.append(", ").append(driverName);
            }
        }

        return winners.toString();
    }
}

