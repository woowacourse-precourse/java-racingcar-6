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

    public boolean judgeRandomNumber(int randomNumber) {
        if (randomNumber >= 4) {
            return true;
        } return false;
    }

    public void moveByRandomNumber(int randomNumber) {
        if (judgeRandomNumber(randomNumber)) {
            move();
        }
    }
}
