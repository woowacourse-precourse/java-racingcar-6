package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCar {
    private String name;
    private Integer move;
    public RacingCar(String name, Integer move){
        this.name = name;
        this.move = move;
    }

    public String getName() {
        return name;
    }

    public Integer getMove() {
        return move;
    }

    public void moveRacingCar(){
        if(shouldMoveGreaterThanRandomValue()){
            this.move +=1;
        }
    }

    public boolean shouldMoveGreaterThanRandomValue(){
        int randomNumber = Randoms.pickNumberInRange(0,9);
        if(randomNumber >=4){
            return true;
        }
        return false;
    }
}
