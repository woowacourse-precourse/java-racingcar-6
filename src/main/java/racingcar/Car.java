package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private int score;
    private String name;

    public Car(String name) {
        this.name = name;
        this.score = 0;
    }

    public String getName() {
        return this.name;
    }

    public String getInfo(){
        return String.format("%s : %s",this.name,"-".repeat(this.score));
    }

    public void run(){
        final int randomInt = Randoms.pickNumberInRange(0,9);
        if(randomInt >= 4){
            this.score ++;
        }
    }
}
