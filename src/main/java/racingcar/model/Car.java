package racingcar.model;

public class Car {

    private static final int MOVE_NUMBER = 4;
    private String name;
    private int position = 0;

    private Car(String name) {
        this.name = name;
    }

    public static Car from(String name) {
        return new Car(name);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void moveForward(int randomNumber) {
        if (randomNumber >= MOVE_NUMBER) {
            position++;
        }
    }

    public boolean isWinner(int maxPosition) {
        return position == maxPosition;
    }
}
