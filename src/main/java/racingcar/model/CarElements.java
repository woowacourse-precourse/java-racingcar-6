package racingcar.model;

import java.util.ArrayList;

public class CarElements {
    private ArrayList<String> cars;

    public static CarElements from(CarObject carElements) {
        return new CarElements(carElements)
    }
}
