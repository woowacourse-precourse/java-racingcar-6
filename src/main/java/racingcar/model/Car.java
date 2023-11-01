package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.view.OutputView;

public class Car {

    private final String name;
    private Integer distance;

    public Car(String name){
        this.name = name;
        this.distance = 0;
    }

    public String getName(){
        return this.name;
    }

    public Integer getDistance(){
        return this.distance;
    }

    public void move(){
        int randomNumber = makeRandomNumber();
        if(canMove(randomNumber)) this.distance += 1;
    }

    public boolean canMove(int num){
        return num >= 4;
    }

    public void showMove() {
        OutputView.printMove(this.distance, this.name);
    }

    private int makeRandomNumber(){ return Randoms.pickNumberInRange(0,9); }
}
