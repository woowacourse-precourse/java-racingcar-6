package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car{

    public String name;
    public int distance;

    public Car(String name){
        this.name = name;
        this.distance = 0;
    }

    public void goOrNot() {

        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            this.distance++;
        }
    }
}
