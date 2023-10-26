package racingcar.model;

import java.util.Comparator;

public class Car implements Comparator<Car> {
    private String name;
    private Integer distance;

    public Car(String name) {
        this.name = validName(name);
        this.distance = 0;
    }

    public String getName() {
        return name;
    }

    public void addDistance(int dice, int forward) {
        if (dice >= forward) {
            distance++;
        }
    }

    public void getDistanceLine() {
        StringBuilder stringBuilder = new StringBuilder();
        System.out.println(stringBuilder.append(getName()).append(" : ").append("-".repeat(Math.max(0, this.distance))));
    }

    public Integer getDistance() {
        return distance;
    }

    private String validName(String name) throws IllegalArgumentException {
        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }
        return name;
    }

    @Override
    public int compare(Car o1, Car o2) {
        return o1.distance.compareTo(o2.distance);
    }
}
