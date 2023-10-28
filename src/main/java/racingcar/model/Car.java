package racingcar.model;
public class Car {

    private final String name;
    private String position;
    public Car(String name, String position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public void updatePosition() {
        this.position += "-";
    }
}
