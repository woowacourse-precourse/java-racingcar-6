package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Car {

    private List<String> carName = new ArrayList<String>();

    Car(List<String> carName) {
        this.carName = carName;
    }
}
