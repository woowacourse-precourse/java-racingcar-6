package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private final String name;

    private int distance;

    public Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    public Car(String name, int distance) {
        this(name);
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public void move() {
        if (RandomManager.isMovingCar()) {
            distance++;
        }
    }

    public String getStatus() {
        return this.name + " : " + "-".repeat(distance);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Car car))
            return super.equals(obj);

        if (!name.equals(car.name))
            return false;
        return distance == car.distance;
    }

    public static List<Car> parseCars(String string) throws IllegalArgumentException{
        String[] carNames = string.split(",");
        ArrayList<Car> list = new ArrayList<>();

        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException(OutputMessage.ERROR_CAR_NAME_LENGTH_LIMIT_OVER);
            }

            Car car = new Car(carName);
            list.add(car);
        }

        return list;
    }
}
