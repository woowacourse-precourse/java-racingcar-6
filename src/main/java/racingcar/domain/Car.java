package racingcar.domain;

public class Car {

    private final String name;

    private String position;

    public Car(String name) {
        this.name = name;
        position = "";
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public int getPositionLength() {
        return position.length();
    }

    public void moveForward() {
        position += "-";
    }
}
