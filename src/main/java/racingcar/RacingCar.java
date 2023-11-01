package racingcar;

public class RacingCar {
    private String name;
    private int moveCount;

    public void setName(String name){
        this.name = name;
    }

    public void setMoveCount(int moveCount){
        this.moveCount = moveCount;
    }

    public String getName(){
        return name;
    }

    public int getMoveCount(){
        return moveCount;
    }
}
