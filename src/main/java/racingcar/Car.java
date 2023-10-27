package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    public static final int LIMIT_NUMBER = 4;
    private final String name;
    private String move;

    public Car(String name){
        this.name = name;
        this.move = "";
    }

    public void run(){
        int randomNum = Randoms.pickNumberInRange(0,9);
        if(randomNum >= LIMIT_NUMBER){
            addMove();
        }
    }

    public void addMove(){
        this.move += "-";
    }

    public String getName(){
        return this.name;
    }

    public String getMove(){
        return this.move;
    }

}

