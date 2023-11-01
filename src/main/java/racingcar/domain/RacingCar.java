package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCar {
    private String name;
    private int move;
    private int randomNumber;

    public RacingCar(String name){
        this.name = name;
        this.move = 0;
    }

    public String getCarName(){
        return this.name;
    }



    public void moveRandomForward(){
        makeRandomNumber();
        if (isOverFour(randomNumber)){
            moveForward();
        }
    }

    public void moveForward(){
        move++;
    }

    public void makeRandomNumber(){
        randomNumber = Randoms.pickNumberInRange(Rule.minNumber, Rule.maxNumber);
    }

    public boolean isOverFour(int value){
        if (value >= Rule.standardValue){
            return true;
        } else{
            return false;
        }
    }

    public int getMove(){
        return this.move;
    }
}
