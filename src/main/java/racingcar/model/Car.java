package racingcar.model;

public class Car {
    private final int MOVE_FORWARD_NUMBER = 4;

    private String name;
    private int distance;

    public Car(String name) {
        this.name = name;
    }

    public void canIMove(int randomNumber) {
        if (randomNumber >= MOVE_FORWARD_NUMBER) {
            move();
        }
    }

    public void move() {
        distance += 1;
    }

    public int findMaxDistance(int max) {
        if (distance > max) {
            max = distance;
        }
        return max;
    }

    public boolean isSameDistance(int max) {
        if (distance == max) {
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }
}
