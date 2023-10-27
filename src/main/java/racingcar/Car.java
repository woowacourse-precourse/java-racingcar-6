package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private final String name;
    private String move;

    public Car(String name){
        this.name = name;
        this.move = "";
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

