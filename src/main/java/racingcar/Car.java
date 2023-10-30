package racingcar;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        position = 0;
    }

    public void move(int randomNumber) {
        if (randomNumber >= GameConfig.MIN_MOVE_VALUE.getValue()) {
            position++;
        }
    }
}
