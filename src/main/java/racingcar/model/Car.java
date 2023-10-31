package racingcar.model;

public class Car {
    private final String name;
    private Integer position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }
}
