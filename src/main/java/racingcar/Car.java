package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private int count = 0;
    private String name;

    public Car(String name) {
        this.name = name;
    }

    public void GoStop() {
        if (Randoms.pickNumberInRange(0, 9) > 3) {
            this.count++;
        }
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }


}
