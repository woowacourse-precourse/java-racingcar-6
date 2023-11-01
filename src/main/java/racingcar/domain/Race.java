package racingcar.domain;

import java.util.*;

public class Race {

    public List<String> raceGameStart(Map<String, String> carMap, String raceCount) {

        int totalRaceCount = Integer.parseInt(raceCount);
        for (int raceLoop = 0; raceLoop < totalRaceCount; raceLoop++) {

            runOnceRace(carMap); // 레이스 1회 진행

            // 1회당 레이스 결과 출력
            for (String carName : carMap.keySet()) {
                System.out.println(carName + " : " + carMap.get(carName));
            }

            System.out.println();
        }

        // 레이스 종료 후 최종 우승자 검사 및 list에 저장 및 return
        return getWinnerCarList(carMap);
    }

    // 입력받은 car Map 에 저장
    public Map<String, String> saveCarMap(String carNameString) {

        Map<String, String> carMap = new LinkedHashMap<>();

        String[] carNameArray = carNameString.split(",");
        for (String carName : carNameArray) {
            carMap.put(carName, "");
        }

        return carMap;
    }

    // 각 car 별로 레이스를 1회씩 진행
    private static void runOnceRace(Map<String, String> carMap) {

        for (String carName : carMap.keySet()) {
            int randomNum = NumberGenerator.getRandomNumberInRange(0, 9);
            if (randomNum > 3) {
                carMap.put(carName, carMap.get(carName) + "-"); // 전진인 경우 "-" 추가해준다
            }
        }
    }

    // 모든 레이스 완료 후 우승자 list에 저장
    private static List<String> getWinnerCarList(Map<String, String> carMap) {

        int maxMoveForwardCount = 0;
        List<String> winnerCarNameList = new ArrayList<>();
        for (String carName : carMap.keySet()) {
            int moveForwardCount = carMap.get(carName).length();
            if (moveForwardCount > maxMoveForwardCount) {
                maxMoveForwardCount = moveForwardCount;
                winnerCarNameList = new ArrayList<>();
                winnerCarNameList.add(carName);
            } else if (moveForwardCount == maxMoveForwardCount) {
                winnerCarNameList.add(carName);
            }
        }

        return winnerCarNameList;
    }

}
