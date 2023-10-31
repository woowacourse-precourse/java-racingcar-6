package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Car {
    public String name;
    public List<String> distance;

    public Car(String name) {
        this.name = name;
        distance = new ArrayList<>();
    }

    public void go(int randomNumber){
        if (randomNumber >= 4){
            distance.add("-");
        }
    }
}
