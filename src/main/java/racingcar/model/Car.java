package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Car {

    private List<String> carName = new ArrayList<String>();
    private int[] carDistance;

    Car(List<String> carName) {
        int length = carName.size();

        this.carName = carName;
        carDistance = new int[length];
    }
}
