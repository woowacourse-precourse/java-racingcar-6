package racingcar.domain;
import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private int score;

    public void Car(String name){
        this.name = name;
        this.score = 0;
    }
    public void moveCar(){
        int moveNum = Randoms.pickNumberInRange(0, 9);
        if(moveNum >= 4){
            score+=1;
        }
    }
    public String getName(){
        return name;
    }
    public int getScore(){
        return score;
    }



}
