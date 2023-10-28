package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import static camp.nextstep.edu.missionutils.Randoms.*;

public class Car {
    private int distance = 0;
    private String name;

    public Car(String name){
        this.name = name;
    }

    public void goStop(){
        int randomNumber = pickNumberInRange(0,9);
        if(randomNumber>4) distance++;
    }
}
