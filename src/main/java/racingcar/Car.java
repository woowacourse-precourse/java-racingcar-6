package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    String name;
    int moveCount;

    public Car(){}
    public Car(String name){
        validName(name);
        this.name = name;
        this.moveCount = 0;
    }
    public void validName(String name){
        if(name.length()>5) throw new IllegalArgumentException("5글자 이하만 가능");
    }
    public void move(){
        if(Randoms.pickNumberInRange(0,9)>=4)
            this.moveCount++;
    }
}
