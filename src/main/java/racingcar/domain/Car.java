package racingcar.domain;

import java.util.List;

public class Car implements Comparable<Car> {
    private String name;
    private int moveDistance;

    private Car() {
    }

    public Car(String name) {
        this.name = name;
        this.moveDistance = 0;
    }

    public void forward() {
        moveDistance++;
    }

    public String currentLocation() {
        return name + " : " + "-".repeat(Math.max(0, moveDistance));
    }

    public StringBuilder isEqualDistance(List<Car> carList) {
        List<String> names = carList.stream()
                .filter(car -> this.moveDistance == car.moveDistance)
                .map(car -> car.name)
                .toList();
        return new StringBuilder(String.join(", ", names));
    }

    @Override
    public int compareTo(Car otherCar) {
        return Integer.compare(otherCar.moveDistance, this.moveDistance);
    }
}
