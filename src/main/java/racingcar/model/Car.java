package racingcar.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Car {

    private List<String> carName = new ArrayList<String>();
    private int[] carDistance;

    Car(String[] carName) {
        this.carName = Arrays.asList(carName);

        int length = carName.length;
        carDistance = new int[length];
    }
}
