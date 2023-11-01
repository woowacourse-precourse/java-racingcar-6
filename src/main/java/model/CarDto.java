package model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.CarConstants;

public class CarDto {
    String name;
    int score=0;

    public void go(){
        if( Randoms.pickNumberInRange(0,9) > CarConstants.GO){
            score++;
        }
    }



}
