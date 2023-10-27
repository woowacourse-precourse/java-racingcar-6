package racingcar.domain;

public class Car {
    private final String name;
    private Integer position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void moveForward(){
        position += 1;
    }

    public String getName() {
        return name;
    }

    public Integer getPosition() {
        return position;
    }
}
