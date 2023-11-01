package racingcar.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RacingCar {

    public static Map<String,String> generateCarNameWithStringHashMap(List<String> CarNames){
        Map<String,String> hashWithForward = new HashMap<>();
        for (String carName : CarNames) {
            hashWithForward.put(carName, "");
        }
        return hashWithForward;
    }

    public static Map<String,Integer> generateCarNameWithRandomNumberHashMap(List<String> CarNames,List<Integer> randomNumbers){

        Map<String,Integer> hashWithRandomNumber = new HashMap<>();
        for(int i = 0 ; i< CarNames.size() ; i++ ){
            hashWithRandomNumber.put(CarNames.get(i),randomNumbers.get(i));
        }

        return hashWithRandomNumber;
    }

    public static List<String> findWinners(Map<String, String> results) {
        int maxDistance = results.values()
                .stream()
                .mapToInt(String::length)
                .max()
                .orElse(0);

        return results.entrySet()
                .stream()
                .filter(entry -> entry.getValue().length() == maxDistance)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}


