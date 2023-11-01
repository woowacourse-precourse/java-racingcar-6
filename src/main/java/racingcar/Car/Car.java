package racingcar.Car;

public class Car {

    private String name;

    private int moveDistance;

    public Car(String name) {
        this.name = name;
        this.moveDistance = 0;
    }

    public void move() {
        moveDistance += 1;
    }

    public boolean judgeRandNum(int randNum) {
        if (randNum >= 4) {
            return true;
        } return false;
    }

    public void moveByRandNum(int randNum) {
        if (judgeRandNum(randNum)) {
            move();
        }
    }
}
