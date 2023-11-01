package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
public class Car {

    private String name;
    private Integer distance=0;

    public Car(String name){
        if(isCorrectCarName(name)){
            this.name=name;
        }
    }

    private Boolean isCorrectCarName(String name){
        if(name.length()>5){
            throw new IllegalArgumentException("자동차 이름이 5자를 초과했습니다.");
        }
        return true;
    }

    

    public Integer measureDistance(){
        return this.distance;
    }

    public String getName(){
        return this.name;
    }
}
