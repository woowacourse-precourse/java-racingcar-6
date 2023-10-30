package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private int location;

    public Car(String name) {
        this.name = name;
        this.location = 0;
    }

    public void move() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            this.location++;
        }
    }

    public int getLocation() {
        return this.location;
    }

    public String getName() {
        return this.name;
    }

    public void print() {
        System.out.print(this.name + " : ");
        for (int i = 0; i < this.location; ++i) {
            System.out.print("-");
        }
        System.out.println();
    }
}
