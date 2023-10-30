package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    public Car(String name) {
        this.name = name;
    }

    private String name;
    private String status;

    public void move() {
        if (isMoveCondition()) {
            status += '-';
        }
        printStatus();
    }

    private boolean isMoveCondition() {
        int randomNumber = Randoms.pickNumberInRange(0,9);
        return randomNumber >= 4;
    }

    private void printStatus() {
        System.out.println(name + " : " + status);
    }
}
