package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String meter="";
    private String name;
    public Car(String name){
        this.name = name;
    }
public void doRace(){
        if(Randoms.pickNumberInRange(0,9)>4){meter = meter+"_";}
        System.out.println(name+" : "+meter);
    }
    public int getLength(){
        return meter.length();
    }
    public String getName(){
        return this.name;
    }
}
