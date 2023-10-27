package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCar {
    private final static int moveCondition = 4;
    private final String name;
    private int moveDistance;

    public RacingCar(String name) {
        this.name = name;
        this.moveDistance  = 0;
    }

    public void move(){
        if(canMove()){
            addMoveDistance();
        }
    }

    private boolean canMove() {
        if(getMoveValue()> moveCondition){
            return true;
        }
        return false;
    }

    private void addMoveDistance() {
        moveDistance+=1;
    }

    private int getMoveValue(){
        return Randoms.pickNumberInRange(0,9);
    }
}
