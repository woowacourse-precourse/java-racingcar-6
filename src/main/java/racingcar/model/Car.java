package racingcar.model;

import java.util.Arrays;
import java.util.List;

public class Car {

    public List<String> carName;
    public int[] carDistance;

    public Car(String[] carName) {
        this.carName = Arrays.asList(carName);

        int length = carName.length;
        carDistance = new int[length];
    }
}
