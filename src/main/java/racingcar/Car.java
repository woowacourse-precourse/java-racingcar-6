package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    String name;
    int location = 0;

    public Car(String _name){
        this.name = _name;
    }

    public void move(){
        if(Randoms.pickNumberInRange(0, 9) >= 4){
            location += 1;
        }
    }

    public String getName(){
        return name;
    }

    public int getLocation(){
        return location;
    }




}
