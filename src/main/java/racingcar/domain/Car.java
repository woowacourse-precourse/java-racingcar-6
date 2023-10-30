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

    public String located() {

        return distance;
    }

    public String getName(){
        return name;
    }

    public void clear(){
        distance="";
    }
}
