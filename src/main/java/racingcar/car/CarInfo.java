package racingcar.car;

public class CarInfo {
    String name;
    int moveCount;


    public CarInfo(String name){
        this.name = name;
        this.moveCount = 0;
    }

    public String getName() {
        return name;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public void setMoveCount(int moveCount) {
        this.moveCount = moveCount;
    }

    @Override
    public String toString() {
        return name;
    }
}
