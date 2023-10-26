package racingcar.model;

import java.util.List;

public class Car {
    public static List<Car> carList;

    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void setPosition(int position) {
        this.position += position;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

}
