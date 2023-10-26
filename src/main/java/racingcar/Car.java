package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private int movingforward;

    public Car(String name) {
        this.name = name;
        this.movingforward = 0;
    }

    void checkMovingForward() {
        int checknum = Randoms.pickNumberInRange(0, 9);

        if(checknum >= 4) {
            this.movingforward++;
        }
    }

    public int getMovingforward() {
        return this.movingforward;
    }

    public String getName() {
        return this.name;
    }
}
