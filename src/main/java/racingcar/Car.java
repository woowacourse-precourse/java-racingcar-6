package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class Car {

    private final String name;
    private Integer distance;

    public Car(String name, Integer distance){
        this.name = name;
        this.distance = distance;
    }

    public void move(){
        if(isMove()) this.distance += 1;
    }

    public boolean isMove(){
        return makeRandomNumber() >= 4;
    }

    public int makeRandomNumber(){
        return Randoms.pickNumberInRange(0,9);
    }
}
