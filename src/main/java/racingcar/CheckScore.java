package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class CheckScore {
    public static void compareScore(List<Car> cars){
        HashMap<String, Integer> scoreHashMap = new HashMap<>();
        for(Car car: cars){
            scoreHashMap.put(car.getName(), car.getPosition());
        }
        selectWinner(scoreHashMap);
    }
    public static void selectWinner(HashMap<String, Integer> scoreHashMap){
        int MAX_value = Collections.max(scoreHashMap.values());
        List<String> winnerList = new ArrayList<>();
        for(String key: scoreHashMap.keySet()){
            if(scoreHashMap.get(key).equals(MAX_value)){
                winnerList.add(key);
            }
        }
        OutputPrinter.winnerPrinter(winnerList);
    }
}
