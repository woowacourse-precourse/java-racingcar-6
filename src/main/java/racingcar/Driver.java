package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;

public class Driver {

    private String name;
    private int score;
    private Car car;

    public Driver(String name){
        this.name = name;
        this.score = 0;
        this.car = new Car();
    }

    public static Driver of(String name){
        if (name.length() > 5){
            throw new IllegalArgumentException("이름은 5글자 이하");
        }
        return new Driver(name);
    }

    public void drive(){
        int drivingDistance;
        if (Randoms.pickNumberInRange(0, 9) >= 4){
            drivingDistance = this.car.accelerator(this);
        } else {
            drivingDistance= this.car.carBreak(this);
        }
        this.score += drivingDistance;
    }

    public String getName(){
        return this.name;
    }

    public int getScore(){
        return this.score;
    }
}
