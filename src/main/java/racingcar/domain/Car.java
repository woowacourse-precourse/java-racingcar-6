package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Car {

    private String name;
    private String distance="";

    public Car(String name){
        this.name=name;
    }

    public String moveForward() {
        distance+="-";
        return distance;
    }

    public String moveStop() {
        return distance;
    }

    public List<Integer> located() {

        return null;
    }

    public String getName(){
        return name;
    }
}
