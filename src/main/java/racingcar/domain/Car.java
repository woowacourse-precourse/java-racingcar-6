package racingcar.domain;

public class Car implements Comparable<Car>{

    private final String name;

    private int totalMovedDistance;

    public Car(String name) {
        this.name = name;
        this.totalMovedDistance = 0;
    }

    public Car(String name, int totalMovedDistance) {
        this.name = name;
        this.totalMovedDistance = totalMovedDistance;
    }

    public void move() {
        totalMovedDistance += 1;
    }

    public String getName() {
        return name;
    }

    public int getTotalMovedDistance() {
        return totalMovedDistance;
    }

    @Override
    public int compareTo(Car other) {
        return this.totalMovedDistance - other.totalMovedDistance;
    }

    public boolean isSamePosition(Car other){
        return this.totalMovedDistance ==  other.totalMovedDistance;
    }
}
