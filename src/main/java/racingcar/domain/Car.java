package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private String carName;
    private int position;

    public Car(String carName, int position) {
        this.carName = carName;
        this.position = position;
    }

    public boolean increasePosition(String position) {
        if(position.equals("STRAIGHT")) {
            this.position++;
            return true;
        }
        return false;
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }
}
