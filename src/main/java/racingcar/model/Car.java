package racingcar.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Car {

    public List<String> carName = new ArrayList<String>();
    public int[] carDistance;

    Car(String[] carName) {
        this.carName = Arrays.asList(carName);

        int length = carName.length;
        carDistance = new int[length];
    }
}
