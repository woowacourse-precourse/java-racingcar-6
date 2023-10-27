package racingcar.model;

public class Car {
    private String name;
    private Integer distance;

    public String getName() {
        return name;
    }

    public Integer getDistance() {
        return distance;
    }

    public Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    public Car(String name, Integer distance) {
        this.name = name;
        this.distance = distance;
    }

    public void updateDistance() {
        this.distance++;
    }
}
