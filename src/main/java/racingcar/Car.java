package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private int goCount = 0;
    public Car(String name) {
        this.name = name;
    }

    public void goOrStop() {
        if(Randoms.pickNumberInRange(0,9) >= 4) {
            goCount++;
        }
    }
}
