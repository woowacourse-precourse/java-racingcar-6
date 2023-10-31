package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    public String name;
    public int position;

    public Car(String name){
        this.name=name;
    }

    public void moveOrStay(){
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            ++position;
        }
    }
}
