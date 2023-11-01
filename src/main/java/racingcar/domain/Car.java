package racingcar.domain;

import java.util.Objects;

public class Car implements Comparable<Car> {

    private String name;
    private int idx, count;

    public Car(int idx, String name) {
        this.name = name;
        count = 0;
    }

    public Car(String name, int count) {
        this.name = name;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        Car other = (Car) object;
        return this.name.equals(other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public int compareTo(Car car) {
        if (this.count == car.count) {
            return this.idx - car.idx;
        }

        return car.count - this.count;
    }

    public void forward() {
        count++;
    }
}
