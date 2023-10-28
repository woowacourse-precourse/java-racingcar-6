package racingcar;

public class Car {

    private String name;
    private int moveNum;

    public Car(String name) {
        this.name = name;
        this.moveNum = 0;
    }

    public int getMoveNum() {
        return moveNum;
    }

    public void move(int randomNumber) {
        if (randomNumber >= 4) {
            moveNum++;
        }
    }
}
