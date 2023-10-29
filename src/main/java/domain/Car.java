package domain;

import java.util.Arrays;
import java.util.List;

public class Car {

    private String name;
    private int position;

    public Car(String carName){
        this.name = carName;
        this.position = 0;
    }

    public String getName(){
        return name;
    }
    public int getPosition(){
        return position;
    }

    public List<String> convertCarName(String carName) {
        List<String> carNames = Arrays.asList(carName.split(","));
        return carNames;
    }

}
