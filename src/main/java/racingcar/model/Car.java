package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.validator.Util;

import java.util.Comparator;

import static racingcar.validator.Constants.*;
public class Car implements Comparable<Car> {
    @Override
    public int compareTo(Car o) {
        return this.getPosition() - o.getPosition();
    }
    private final String NAME;
    private static int position =0;
    public Car(String name){
        this.NAME = name;
    }
    public int getPosition(){
        return position;
    }
    public String getName(){
        return NAME;
    }
    public void go(){
        if(getRandomNumber() >=4){
            position++;
        }
    }
    public String getResult(){
        String result = getName()+":"+Util.getDashString(DASH,getPosition());
        return result;
    }
    public int getRandomNumber(){
        return Randoms.pickNumberInRange(STARTNUM,ENDNUM);
    }
}
