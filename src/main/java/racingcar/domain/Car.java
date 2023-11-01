package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    String name;
    int location = 0;

    public Car(String name){
        this.name = name;
    }

    public void randomMove() {
        int random = Randoms.pickNumberInRange(0,9);
        if(random >= 4){
            location++;
        }

    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }
}
