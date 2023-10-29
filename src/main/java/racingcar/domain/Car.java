package racingcar.domain;

public class Car {
    private String name;
    private int totalDistance;

    public Car(String name) {
        this.name = name;
        this.totalDistance = 0;
    }

    public void addDistance() {
        ++this.totalDistance;
    }

    public int getTotalDistance() {
        return totalDistance;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
