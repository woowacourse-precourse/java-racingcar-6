package racingcar.model;

public class Car {
    private final String name;
    private int distance;

    public Car(String name) {
        this.name = name;
    }

    public void addDistance() {
        this.distance++;
    }

    public String getName(){
        return name;
    }

    public int getDistance() {
        return distance;
    }
}
