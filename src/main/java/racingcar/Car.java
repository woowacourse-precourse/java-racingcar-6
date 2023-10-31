package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private static final String DASH = "-";
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

    public int makeRandomNumber(){ return Randoms.pickNumberInRange(0,9); }

    public void printMove() {
        String dash = DASH.repeat(this.distance);
        System.out.println(this.name + " : " + dash);
    }
}
