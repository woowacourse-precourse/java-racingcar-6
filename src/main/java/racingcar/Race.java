package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Race {

    private static Map<String, String> raceResultsHMap = new LinkedHashMap<>();


    public static Map<String, String> registerCars(List<String> carNamesArrayList) {
        for (String carName : carNamesArrayList) {
            raceResultsHMap.put(carName, "");
        }

        return raceResultsHMap;
    }


    public static Map<String, String> doRace(Map<String, String> readyForRaceHMap) {
        for (var carNameKey : readyForRaceHMap.keySet()) {
            String eachCarRaceResult = readyForRaceHMap.get(carNameKey);
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            if (randomNumber >= 4) {
                eachCarRaceResult += "-";
            }
            readyForRaceHMap.put(carNameKey, eachCarRaceResult);
        }

        raceResultsHMap = readyForRaceHMap;

        return raceResultsHMap;
    }


    public static void showEachRace(Map<String, String> raceResultsHMap) {
        Set<Map.Entry<String, String>> raceResultsES = raceResultsHMap.entrySet();

        for (var entry : raceResultsES) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.printf("%s : " + "%s%n", key, value);
        }

        System.out.println();
    }


}

