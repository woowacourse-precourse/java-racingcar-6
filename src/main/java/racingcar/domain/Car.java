package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private static final Integer initialDistance = 0;
    private String name;
    private Integer distance;

    public Car(String name){
        this.name = name;
        this.distance = initialDistance;
    }

    public Car(String name, Integer distance){
        this.name = name;
        this.distance = distance;
    }

    public String getName(){
        return name;
    }

    public Integer getDistance(){
        return distance;
    }

    public void decideMoving(){
        Integer number = Randoms.pickNumberInRange(0,9);
        if (number >= 4) distance++;
    }

    public Boolean isDistanceSame(Integer distanceToCompare){
        if (distance == distanceToCompare) return true;
        return false;
    }
}
