package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private String name = null;
    private String position = "";

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    private void moveForward() {
        if(Randoms.pickNumberInRange(0, 9) >= 4) {
            this.position += "-";
        }
    }

    private void display() {
        System.out.println(this.name + " : " + this.position);
    }

    public int getPositionDistance() {
        return this.position.length();
    }

    public void performEachRound() {
        this.moveForward();
        this.display();
    }

}