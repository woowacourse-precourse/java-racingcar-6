package racingcar.domain.car;

import java.util.List;
import racingcar.domain.Movable;

public class Car {
    private final String name;
    private int distance;

    public Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }
    public String getCarDistanceChar(){
        String hyphen = "";
        for(int i = 0; i < distance; i++){
            hyphen += '-';
        }
        return hyphen;
    }

    public void goForward(Movable movable){
        if(movable.canMove()){
            distance++;
        }
    }
}
