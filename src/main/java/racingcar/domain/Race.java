package racingcar.domain;

import java.util.HashMap;
import java.util.Map;

public class Race {

    public Map<String, String> saveCarMap(String carNameString) {

        Map<String, String> carMap = new HashMap<>();

        String[] carNameArray = carNameString.split(",");
        for (String carName : carNameArray) {
            carMap.put(carName, "");
        }

        return carMap;
    }

    public void raceGameStart(Map<String, String> carMap, String raceCount) {

        int totalRaceCount = Integer.parseInt(raceCount);
        for (int raceLoop = 0; raceLoop < totalRaceCount; raceLoop++) {

            // 각 car 별로 레이스를 진행
            for (String carName : carMap.keySet()) {
                int randomNum = NumberGenerator.getRandomNumberInRange(0, 9);
                if (randomNum < 4) {
                    continue;
                } else {
                    carMap.put(carName, carMap.get(carName) + "-");
                }
            }

            // 1회당 레이스 결과 출력
            for (String carName : carMap.keySet()) {
                System.out.println(carName + " : " + carMap.get(carName));
            }

            System.out.println();
        }
    }

}
