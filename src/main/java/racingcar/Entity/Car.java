package racingcar.Entity;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        int num = Randoms.pickNumberInRange(0,9);
        if(num >= 4){
            position ++;
        }
    }
}
