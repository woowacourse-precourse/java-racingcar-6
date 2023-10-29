package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.utils.NumberGenerator;

public class RacingCar {
    private final String name;
    private String distance;
    private static final int GO_COUNT = 4;
    public String getName(){
        return name;
    }
    public String getDistance(){
        return distance;
    }
    public RacingCar(String name){
        this.name = name;
        this.distance = "";
    }
    public void go(){
        if(canGo()) this.distance+="-";
        print();
    }
    private void print(){
        System.out.println(name+" : "+distance);
    }
    private boolean canGo(){
        return NumberGenerator.createRandomNumber() >= GO_COUNT;
    }
}
