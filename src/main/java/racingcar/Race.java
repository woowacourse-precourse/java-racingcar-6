package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Race {

    public static Map<String, List<String>> doRace(List<String> carNamesArrayList) {
        Map<String, List<String>> raceResultsHMap = new HashMap<>();


        for (String carName : carNamesArrayList) {
            //일단 각 key를 자동차이름으로 정하고, value를 empty value로 초기화
//            List<String> valuesArrayList = new ArrayList<>();
            raceResultsHMap.put(carName, new ArrayList<>());
        }

        //sol1) HMap.get(key).add()
        //sol2) entrySet => entry.getKey(), entry.getValue()

        for (var carNameKey : raceResultsHMap.keySet()) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            if (randomNumber >= 4) {
                raceResultsHMap.get(carNameKey).add("-");
            }
        }

        return raceResultsHMap;
    }


    public static void showRace(Map<String, List<String>> raceResultsHMap) {
        Set<Map.Entry<String, List<String>>> raceResultsES = raceResultsHMap.entrySet();
        for (var entry : raceResultsES) {
            String key = entry.getKey();
            List<String> value = entry.getValue();

            System.out.printf("%s : " + "%s%n%n", key, value);
        }
    }

}

