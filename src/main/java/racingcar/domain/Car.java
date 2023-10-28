package racingcar.domain;

import java.util.Comparator;

public class Car implements Comparator {
    private final String name;
    private int moveDistance;

    public Car(String name) {
        if (!nameLengthCheck(name)) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.moveDistance = 0;
    }

    public void forward() {
        moveDistance++;
    }

    public String currentLocation() {
        return name + " : " + "-".repeat(Math.max(0, moveDistance));
    }

    private boolean nameLengthCheck(String name) {
        return name.length() <= 5;
    }

    @Override
    public int compare(final Object o1, final Object o2) {
        if (o1 instanceof Car car1 && o2 instanceof Car car2) {
            return Integer.compare(car2.moveDistance, car1.moveDistance);
        }
        return 0;
    }
}
