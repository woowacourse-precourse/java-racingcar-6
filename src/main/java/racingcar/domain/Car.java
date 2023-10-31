package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    public Car(String name) {
        this.name = name;
    }

    private final String name;
    private String status = "";

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public void move(boolean MoveCondition) {
        if (MoveCondition) {
            status += '-';
        }
        printStatus();
    }

    public boolean isMoveCondition() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        return randomNumber >= 4;
    }

    private void printStatus() {
        System.out.println(name + " : " + status);
    }
}
