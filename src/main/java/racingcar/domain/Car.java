package racingcar.domain;

public class Car {
    private static final int MINIMUM_MOVABLE_NUMBER = 4;
    private int position;
    private String name;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void move(int number) {
        if (number >= MINIMUM_MOVABLE_NUMBER) {
            this.position++;
        }
    }

    public int getPosition() {
        return this.position;
    }

    public String getName() {
        return this.name;
    }
}
