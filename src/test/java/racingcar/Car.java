package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private int position;
    Car(String name){
        position=0;
        this.name=name;
    }
    public void move(){
        if(Randoms.pickNumberInRange(0,9)>4) ++position;
    }
    public int getPosition(){
        return position;
    }
    public String getName(){
        return name;
    }
}
