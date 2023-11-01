package racingcar;

public class Car {
    private String name;
    private int currentPosition;

    public Car(String name) {
        this.name = name;
    }
    public void move(int numberToMove) {
        if (numberToMove > 3) {
            currentPosition++;
        }
    }

    public String getName() {
        return name;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }
}
