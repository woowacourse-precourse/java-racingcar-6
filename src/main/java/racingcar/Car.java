package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Random;

public class Car {
    private final String name;
    private int distance;

    public Car(String name){
        this.name = name;
        this.distance = 0;
    }

    public void playRound() {
        if(isMoving()){
            move();
        }
    }

    private void move() {
        this.distance += 1;
    }

    private boolean isMoving() {
        int num = Randoms.pickNumberInRange(0,9);
        return num >= 4;
    }

    public int getDistance() {
        return this.distance;
    }
}
