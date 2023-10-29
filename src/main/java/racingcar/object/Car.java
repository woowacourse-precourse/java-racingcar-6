package racingcar.object;

public class Car {
    private String name;
    private String moveForward;

    public Car(String name, String moveForward) {
        this.name = name;
        this.moveForward = moveForward;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMoveForward() {
        return moveForward;
    }

    public void setMoveForward(String moveForward) {
        this.moveForward = moveForward;
    }
}
