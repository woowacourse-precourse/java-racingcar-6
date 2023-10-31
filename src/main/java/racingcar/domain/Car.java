package racingcar.domain;

public class Car implements Comparable<Car> {

    private final String name;
    private Integer forwardDistance = 0;

    public Car(String name) {
        this.name = name;
    }

    public void forward() {
        this.forwardDistance++;
    }

    public String getName() {
        return name;
    }

    public Integer getForwardDistance() {
        return forwardDistance;
    }

    @Override
    public int compareTo(Car other) {
        return Integer.compare(this.forwardDistance, other.forwardDistance);
    }

    @Override
    public String toString() {
        StringBuilder car = new StringBuilder();
        car.append(String.format("%s : ", name));
        car.append("-".repeat(forwardDistance));
        return car.toString();
    }
}
