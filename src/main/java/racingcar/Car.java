package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private static final int WIN_THRESHOLD = 4;
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

    public void move(int moveValue) {
        if (moveValue >=WIN_THRESHOLD) {
            position++;
        }
    }

    public static List<Car> createCars(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName.trim()));
        }
        return cars;
    }
}
