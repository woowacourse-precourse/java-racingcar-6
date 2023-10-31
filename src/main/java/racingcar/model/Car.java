package racingcar.model;

import java.util.Objects;

public class Car {
    String Name;
    Long distance;

    public Car(String carName, Long i) {
        Name = carName;
        distance = i;
    }

    public String getName(){
        return Name;
    }
    public Long getDistance() {
        return distance;
    }

    public void incDistance(){
        ++distance;
    }

    public boolean isSame(Long input){
        return Objects.equals(distance, input);
    }

}
