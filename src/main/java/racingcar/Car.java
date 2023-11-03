package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    public String name;
    public int count;
    public boolean win;

    public static final int THRESHOLD = 4;

    public Car(String name) {
        this.name = name;
        this.count = 0;
        this.win = false;
    }

    public void move() {
        if (Randoms.pickNumberInRange(0, 9) >= THRESHOLD) {
            this.count++;
        }
    }

}
