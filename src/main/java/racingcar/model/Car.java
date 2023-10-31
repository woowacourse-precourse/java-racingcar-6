package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.validator.Util;

import java.util.Comparator;

import static racingcar.validator.Constants.*;
public class Car implements Comparable<Car> {
    @Override
    public int compareTo(Car o) {
        return o.getPosition() - this.getPosition();
    }
    private final String NAME;
    private int position =0;
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
        return NAME+" : "+ Util.getDashString(DASH,position);
    }
    public boolean isWinner(int winDistance) {
        return position == winDistance;
    }
    public int getRandomNumber(){
        return Randoms.pickNumberInRange(STARTNUM,ENDNUM);
    }
}
