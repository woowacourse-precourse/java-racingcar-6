package racingcar;

import java.util.ArrayList;

public class Car implements Comparable<Car> {
    private String name;
    private String position = "";
    private int distance;
    private static int round;
    private final ArrayList<Car> cars = new ArrayList<>();

    Car() {
    }

    Car(String name) {
        this.name = name;
    }
    @Override
    public int compareTo(Car car) {
        return Integer.compare(this.distance, car.distance);
    }
}
