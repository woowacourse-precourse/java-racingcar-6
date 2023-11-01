package racingcar.domain;

import java.util.*;

public class Race {

    public Map<String, String> saveCarMap(String carNameString) {

        Map<String, String> carMap = new LinkedHashMap<>();

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
                if (randomNum > 3) {
                    carMap.put(carName, carMap.get(carName) + "-"); // 전진인 경우 "-" 추가해준다
                }
            }

            // 1회당 레이스 결과 출력
            for (String carName : carMap.keySet()) {
                System.out.println(carName + " : " + carMap.get(carName));
            }

            System.out.println();
        }

        // 레이스 종료 후 최종 우승자 검사 및 list에 저장
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

            // System.out.println(carName + " -- moveForwardCount = " + moveForwardCount);
        }

        // 최종 우승자 출력
        String commaWinnerCarName = String.join(",", winnerCarNameList);
        System.out.println("최종 우승자 : " + commaWinnerCarName);
    }

}
