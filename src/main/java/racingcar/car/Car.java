package racingcar.car;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private Integer location;

    public Car(String name){
        this.name = name;
        this.location = 0;
    }
    public void move(){
        if(Randoms.pickNumberInRange(0,9) >= 4){
            location += 1;
        }
    }

    public Integer getLocation(){
        return location;
    }

    public String getName(){
        return name;
    }
}
