package racingcar.domain;

import static racingcar.constant.Constant.*;

import java.util.Map;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constant.Constant;

public class Race {

    private Map<String,Car> playCars;

    public Race(Map<String,Car> playCars){
        this.playCars=playCars;
    }


    public void play(){

    }

    private void decideMoveOrStay(){

    }

    private int getRandomNumber(){
        return Randoms.pickNumberInRange(RANDOM_NUMBER_MIN,RANDOM_NUMBER_MAX);
    }

}
