package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.view.OutputView;

public class Car {
    private static final Integer MOVING = 1;
    private static final Integer MOVING_BOUNDARY_VALUE = 4;
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
        if(canMove(randomNumber)) this.distance += MOVING;
    }

    public boolean canMove(int num){
        return num >= MOVING_BOUNDARY_VALUE;
    }

    public void showMove() {
        OutputView.printMove(this.distance, this.name);
    }

    private int makeRandomNumber(){ return Randoms.pickNumberInRange(0,9); }
}
