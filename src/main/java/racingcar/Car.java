package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private int position;
    Car(String name){
        position=0;
        this.name=name;
    }
    void move(){
        if(Randoms.pickNumberInRange(0,9)>4) ++position;
    }
    int getPosition(){
        return position;
    }
    String getName(){
        return name;
    }
}
