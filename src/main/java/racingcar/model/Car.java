package racingcar.model;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;

    private String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        this.position++;
    }

    public void tryMove(int randomNumber) {
        if (randomNumber >= 4) {
            move();
        }
    }
}
