package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void moveOrNot() {
        int randInt = Randoms.pickNumberInRange(0, 9);
        if (randInt >= 4) {
            position++;
        }
    }

    public void printPosition() {
        System.out.println(name + " : " + "-".repeat(position));
    }

}
