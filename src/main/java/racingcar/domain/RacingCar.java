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

    public String getName() {
        return name;
    }

    public int getMoveNumber() {
        return moveNumber;
    }
}
