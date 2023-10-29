package racingcar.model;

import racingcar.validation.InputValidation;

import java.util.LinkedHashMap;
import java.util.Map;

public class Car {
  private String carName;
  private int position;

    public Car(String name) {
        this.carName = name;
        position = 0;
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }
}
