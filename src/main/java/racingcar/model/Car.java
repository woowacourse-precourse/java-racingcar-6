package racingcar.model;

public class Car {
    private final String name;
    private int move;

    public Car(String name) {
        this.name = name;
        this.move = 0;
    }

    public void moveForward(int number) {
        if (number >= 4) move++;
    }

    public String getName() {
        return name;
    }

    public int getMove() {
        return move;
    }
}
