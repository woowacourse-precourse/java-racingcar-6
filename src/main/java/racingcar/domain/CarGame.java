package racingcar.domain;

import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public class CarGame {

    private TreeMap<String, Integer> carDistances = new TreeMap<>();

    public void CarGame(List<String> cars) {
        for(String car : cars){
            carDistances.put(car,0);
        }
    }

    public void move(String car){
        carDistances.put(car,carDistances.get(car)+1);
        printTreeMap();
    }

    public void printTreeMap(){
        carDistances.forEach((key, value) -> System.out.println("Key: " + key + ", Value: " + value));
    }
}
