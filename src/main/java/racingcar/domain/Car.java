package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Car {

    private static final int MOVE_CONDITION = 4;
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move(){
        if (NumberGenerator.createRandomNumber() >= MOVE_CONDITION) {
            position++;
        }
    }

    public static List<Car> createCars(String[] names) {

        List<Car> cars = new ArrayList<>();

        for (String name : names) {
            cars.add(createCar(name));
        }
        return cars;
    }

    private static Car createCar(String name) {
        return new Car(name);
    }

}
