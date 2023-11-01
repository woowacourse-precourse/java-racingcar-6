package racingcar.car;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int score;

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }

    public void oneStep(){
        int randomNum = pickRandomNum();
        if(randomNumCheck(randomNum)){
            this.score = this.score+1;
        }
    }
    public boolean randomNumCheck(int num){
        return num >= NumConstant.condition;
    }
    public int pickRandomNum(){
        return Randoms.pickNumberInRange(NumConstant.start,NumConstant.end);
    }
    public Car(String name,int score){
        this.name = name;
        this.score = score;
    }
}
