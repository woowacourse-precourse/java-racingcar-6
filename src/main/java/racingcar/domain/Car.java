package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private int forwardNum;
    private int randomNum;

    public Car(String name){
        this.name = name;
        this.forwardNum = 0;
    }

    public String getName(){
        return this.name;
    }

    public int getForwardNum(){
        return this.forwardNum;
    }

    public int getRandomNum(){
        return this.randomNum;
    }

    public void increaseForwardNum(){
        this.forwardNum++;
    }

    public int initRandomNum(){
        return Randoms.pickNumberInRange(0,9);
    }
}
