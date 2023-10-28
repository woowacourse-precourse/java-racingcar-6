package racingcar.car;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final int toJumpVal = 4;

    private final String name;

    private int dist;


    public Car(String name) {
        this.name = name;
        this.dist = 0;
    }

    public void jump(){
        if(Randoms.pickNumberInRange(0,9) >= toJumpVal){
            this.dist ++;
        }
    }

    public int getDist(){
        return this.dist;
    }

    public String getName(){
        return this.name;
    }
}
