package racingcar.model;

import java.util.Objects;
import java.util.UUID;

public class Car {
    private final UUID id = UUID.randomUUID();
    private final String name;
    private long distance;

    public Car(String name) {
        this.name = name;
        this.distance = 0L;
    }

    public String getName() {
        return name;
    }

    public long getDistance() {
        return distance;
    }

    public void increaseDistance() {
        this.distance += 1;
    }

    @Override
    public String toString() {
        return this.name + " : " + distanceToString();
    }

    private String distanceToString() {
        if (distance > 20) {
            return "-".repeat(20) + "+" + (distance - 20);
        }
        
        return "-".repeat((int) distance);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(id, car.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
