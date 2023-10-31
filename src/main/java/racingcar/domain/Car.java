package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private int score;
    private final String name;

    public Car(String name) {
        this.name = name;
        this.score = 0;
    }

    public String ifMaxScore(int maxScore){
        if(this.score == maxScore){
            return this.name;
        }
        return "";
    }

    public int run(){
        final int randomInt = Randoms.pickNumberInRange(0,9);
        if(randomInt >= 4){
            this.score ++;
        }
        final String printFormat = String.format("%s : %s",this.name,"-".repeat(this.score));
        System.out.println(printFormat);
        return this.score;
    }

}
