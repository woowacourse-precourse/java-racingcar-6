package racingcar.domain;

public class Car {
    private static final int MOVE_THRESHOLD = 4;
    private final String name;
    private int position = 0;

    public Car(String name) {
        if (name == null || name.length() > 5) {
            throw new IllegalArgumentException("Invalid car name");
        }
        this.name = name;
    }

    public void move(int randomNumber) {
        if (randomNumber >= MOVE_THRESHOLD) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public String toString() {
        StringBuilder display = new StringBuilder(name + " : ");
        for (int i = 0; i < position; i++) {
            display.append("-");
        }
        return display.toString();
    }
}