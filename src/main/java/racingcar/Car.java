package racingcar;

import static camp.nextstep.edu.missionutils.Randoms.*;

public class Car {
    private int distance = 0;
    private final String name;

    public Car(String name){
        this.name = name;
    }

    public void goStop(){
        if(pickNumberInRange(0,9) >= 4) distance++;
    }

    public String getName(){
        return name;
    }

    public int getDistance(){
        return distance;
    }

}
