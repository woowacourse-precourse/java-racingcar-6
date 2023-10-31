package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    final private String name;
    private int location = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getLocation() {
        return location;
    }

    public void move() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            location++;
        }
    }

    public void status() {
        System.out.println(name + " : " + "-".repeat(location));
    }
}
