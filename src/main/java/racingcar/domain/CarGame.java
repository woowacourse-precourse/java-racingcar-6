package racingcar.domain;

import java.util.HashMap;
import java.util.List;
//import java.util.TreeMap;

public class CarGame {

    public static HashMap<String, Integer> carDistances = new HashMap<>();

    public void CarGame(List<String> cars) { //List -> Map으로 저장
        for(String car : cars){
            carDistances.put(car,0);
        }
    }

    public void move(String car){
        carDistances.put(car,carDistances.get(car)+1); //점수 누적 저장
    }

}
