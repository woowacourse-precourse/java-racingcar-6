package racingcar.model;

public class Car {
    private String name;
    private Integer distance;

    public Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    public void incrementDistance() {
        this.distance++;
    }

    public String getName() {
        return name;
    }

    public Integer getDistance() {
        return distance;
    }
}
