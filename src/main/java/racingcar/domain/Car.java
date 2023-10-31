package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private int moveCnt;

    public Car(String name){
        this.name = name;
    }

    public int getRandomNum(){
        return Randoms.pickNumberInRange(0, 9);
    }

    public void moveForward(){
        this.moveCnt += 1;
    }

}
