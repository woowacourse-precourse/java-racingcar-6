package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Car {
    private String name;
    private int currentStep;

    public Car(final String name) {
        this.name = name;
        this.currentStep = 0;
    }

    public void move() {
        currentStep+=1;
    }
    public void setName(final String name) {
        this.name = name;
    }
    public void moveIfOverFour(){
        int pickNumber = Randoms.pickNumberInRange(0, 9);
        if (pickNumber >= 4) {
            this.move();
        }
    }
}
