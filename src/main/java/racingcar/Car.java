package racingcar;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        position = 0;
    }

    public void move() {
        position++;
    }

    public void move(int power) {
        if (isMovablePower(power)) {
            move();
        }
    }

    public boolean isMovablePower(int power) {
        return power >= 4;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
