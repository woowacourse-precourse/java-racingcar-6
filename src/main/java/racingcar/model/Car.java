package racingcar.model;

public class Car {
    private String name;
    private Integer distance;

    public Car(String name, Integer distance) {
        this.name = name;
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public Integer getDistance() {
        return distance;
    }
}
