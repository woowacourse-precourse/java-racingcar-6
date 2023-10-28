package racingcar.Car;

import racingcar.Constants.CarDefaultValues;
public class Car {
    private final String name;
    private int position = CarDefaultValues.START_POSITION;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public int getPosition() {
        return position;
    }

    public void move(int distance) {
        this.position += distance;
    }
}