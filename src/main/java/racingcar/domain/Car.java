package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final int BASIC = 4;
    private static final int RANDOM_MIN = 0;
    private static final int RANDOM_MAX = 0;
    private final String name;
    private int position = 0;

    public Car(String name){
        this.name = name;
    }


    public String getName(){
        return this.name;
    }

    public int getPosition(){
        return this.position;
    }

    public void choice(){
        if(Go()) position++;
    }

    private boolean Go(){
        if(Randoms.pickNumberInRange(RANDOM_MIN, RANDOM_MAX) >= BASIC){
            return true;
        }
        return false;
    }

    public boolean isSamePosition(int position){
        if(this.position == position){
            return true;
        }

        return false;
    }
}
