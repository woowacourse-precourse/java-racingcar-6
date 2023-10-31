package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Race {

//    public static Map<String, List<String>> doRace(List<String> carNamesArrayList) {
//        Map<String, List<String>> raceResultsHMap = new HashMap<>();
//
//        for (String carName : carNamesArrayList) {
//            //일단 각 key를 자동차이름으로 정하고, value를 empty value로 초기화
//            List<String> valuesArrayList = new ArrayList<>();
//            raceResultsHMap.put(carName, valuesArrayList);
//        }
//
//
//        //sol1) HMap.get(key).add()
//        //sol2) entrySet => entry.getKey(), entry.getValue()
//
//        for (var carNameKey : raceResultsHMap.keySet()) {
//            int randomNumber = Randoms.pickNumberInRange(0, 9);
//            if (randomNumber >= 4) {
//                raceResultsHMap.get(carNameKey).add("-");
//            }
//        }
//
//        return raceResultsHMap;
//    }


    private static Map<String, String> raceResultsHMap = new LinkedHashMap<>();

    public static Map<String, String> registerCars(List<String> carNamesArrayList) {
        for (String carName : carNamesArrayList) {
            //empty value로 각 자동차의 value 초기화
            raceResultsHMap.put(carName, "");
        }

        return raceResultsHMap;
    }

    //2차시도: hashMap values를 그냥 String 이어붙이기로:
    public static Map<String, String> doRace(Map<String, String> readyForRaceHMap) {

//        for (String carName : carNamesArrayList) {
//            //empty value로 각 자동차의 value 초기화
//            raceResultsHMap.put(carName, "");
//        }

        for (var carNameKey : readyForRaceHMap.keySet()) {
            String eachCarRaceResult = readyForRaceHMap.get(carNameKey);
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            if (randomNumber >= 4) {
                eachCarRaceResult += "-"; // 이부분에서 deep copy vs shallow copy
            }
            readyForRaceHMap.put(carNameKey, eachCarRaceResult);
        }

        raceResultsHMap = readyForRaceHMap;




        //sol1) HMap.get(key).add()
        //sol2) entrySet => entry.getKey(), entry.getValue()


        return raceResultsHMap;
    }


//    public static void showRace(Map<String, List<String>> raceResultsHMap) {
//        Set<Map.Entry<String, List<String>>> raceResultsES = raceResultsHMap.entrySet();
//        for (var entry : raceResultsES) {
//            String key = entry.getKey();
//            List<String> value = enㅏtry.getValue();
//
//            System.out.printf("%s : " + "%s%n%n", key, value);
//        }다
//    }

    public static void showRace(Map<String, String> raceResultsHMap) {
        Set<Map.Entry<String, String>> raceResultsES = raceResultsHMap.entrySet();
        for (var entry : raceResultsES) {
            String key = entry.getKey();
            String value = entry.getValue();

            System.out.printf("%s : " + "%s%n", key, value);
        }
        System.out.println();
    }

}

