package racingcar.domain;

import java.util.List;

public class Car {
    private static final int CAN_GO_FORWARD_START = 4;
    private int forward;
    private String name;

    public Car(String name) {
        this.name = name;
        forward = 0;
    }

    public void goForward(int randomNum){
        if(randomNum >= CAN_GO_FORWARD_START){
            forward++;
        }
    }

    public int getForward() {
        return forward;
    }

    public String getName() {
        return name;
    }

}
