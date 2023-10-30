package racingcar;

public class Car {
    private String name;
    private int position;

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void moveForward(int i) {
        if (i >= 4) {
            position++;
        }
    }
}
