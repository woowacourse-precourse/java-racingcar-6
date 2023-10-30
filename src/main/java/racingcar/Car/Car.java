package racingcar.Car;

import racingcar.Constants.CarConstants;
public class Car {
    private final String name;
    private int position = CarConstants.START_POSITION;

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