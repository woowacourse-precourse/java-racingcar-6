package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
public class Car {

    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public String getName(){
        return name;
    }

    public int getPosition(){
        return position;
    }

    public int randomSpeed(){
        return Randoms.pickNumberInRange(0, 9);
    }

    public void move(){
        position++;
    }


}
