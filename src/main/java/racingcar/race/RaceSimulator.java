package racingcar.race;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Map;

public class RaceSimulator {
    public void simulateRace(Map<String, String> driverMap, int opportunity) {
        for (int i = 0; i < opportunity; i++) {
            simulateSingleRace(driverMap);
        }
    }

    private void simulateSingleRace(Map<String, String> driverMap) {
        for (String driverName : driverMap.keySet()) {
            System.out.print(driverName + " : ");
            int randomNum = Randoms.pickNumberInRange(0, 9);
            if (4 <= randomNum && randomNum <= 9) {
                driverMap.put(driverName, driverMap.get(driverName) + "-");
            }
            System.out.println(driverMap.get(driverName));
        }
        System.out.println();
    }
}


