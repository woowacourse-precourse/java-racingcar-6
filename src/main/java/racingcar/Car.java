package racingcar;

public class Car {

    String name;
    int moveNum;

    public Car(String name, int moveNum) {
        this.name = name;
        this.moveNum = moveNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoveNum() {
        return moveNum;
    }

    public void setMoveNum(int moveNum) {
        this.moveNum = moveNum;
    }

}
