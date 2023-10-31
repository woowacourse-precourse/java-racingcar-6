package racingcar.domain;

public class RacingCar {
    private String name;
    private int moveNumber;

    public RacingCar(String name){
        this.name = name;
        moveNumber = 0;
    }

    public void increaseMoveNumber(){
        moveNumber++;
    }

    public int getMoveNumber() {
        return moveNumber;
    }

    @Override
    public String toString(){
        return name;
    }
}
