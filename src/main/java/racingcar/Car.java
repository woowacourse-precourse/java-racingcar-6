package racingcar;

public class Car {

    private String name;
    private StringBuilder position = new StringBuilder();

    public void moveForward() {
        this.position.append("-");
    }

}
