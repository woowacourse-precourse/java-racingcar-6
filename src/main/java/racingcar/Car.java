package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private final String name;
    private int distance;

    public Car(String name){
        this.name = name;
        this.distance=0;
    }

    public void move(){
        if(Randoms.pickNumberInRange(0,9)>=4){
            this.distance++;
        }
    }

    public String getName(){
        return this.name;
    }

    public int getDistance(){
        return this.distance;
    }

    @Override
    public String toString() {
        String res = "";
        res+=this.name;
        res+=" : ";
        res+="-".repeat(distance);
        res+="\n";
        return res;
    }
}
