package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private int score;
    private final String name;

    public Car(String name) {
        this.name = name;
        this.score = 0;
    }

    public String getName() {
        return this.name;
    }
    public int getScore() {return this.score;}

    public String run(){
        final int randomInt = Randoms.pickNumberInRange(0,9);
        if(randomInt >= 4){
            this.score ++;
        }
        return String.format("%s : %s",this.name,"-".repeat(this.score));
    }

}
