package model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.CarConstants;

public class CarDto {
    String name;
    int score=0;

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public CarDto(String name) {
        this.name = name;
    }

    public CarDto(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public void go(){
        if( Randoms.pickNumberInRange(0,9) > CarConstants.GO){
            score++;
        }
    }



}
