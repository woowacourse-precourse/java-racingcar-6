package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private String position;

    public Car(String name) {
        this.name = name;
        this.position = "";
    }

    public String move() {
        int RandomNum = Randoms.pickNumberInRange(0, 9);
        if(RandomNum>=4){
            position += "-";
        }
        return toString();
    }

    public String getName() {
        return this.name;
    }

    public Integer getPosition() {
        return position.length();
    }

    @Override
    public String toString() {
        return name + " : " + position;
    }
}
