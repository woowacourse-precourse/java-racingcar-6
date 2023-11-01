package racingcar;

public class Car {
    private String name;
    private String position;

    public Car(String name) {
        this.name = name;
        this.position = "";
    }

    public Car(String name, String position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void moveForward() {
        this.position += "-";
    }

    public int getPositionLength() {
        return position.length();
    }

    public String nameAndPosition() {
        return name + " : " + position;
    }

    public boolean isWinner(int maxPositionLength) {
        return getPositionLength() == maxPositionLength;
    }
}
