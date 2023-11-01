package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private int score;
    private final String name;

    public Car(String name) {
        this.name = name;
        this.score = 0;
    }

    public String getName(){
        return this.name;
    }

    public String ifMaxScore(int maxScore){
        if(this.score == maxScore){
            return this.name;
        }
        return "";
    }

    public boolean isMove(){
        final int randomInt = Randoms.pickNumberInRange(0,9);
        return randomInt >= 4;
    }

    public int run(){
        if(isMove()){
            this.score ++;
        }
        final String printFormat = String.format("%s : %s",this.name,"-".repeat(this.score));
        System.out.println(printFormat);
        return this.score;
    }

}
